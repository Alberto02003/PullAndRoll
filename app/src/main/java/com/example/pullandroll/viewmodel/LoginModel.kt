package com.example.pullandroll.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.pullandroll.objetos.Datos
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class LoginModel: ViewModel(){
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val conexion = FirebaseFirestore.getInstance()

    private lateinit var listenerReg : ListenerRegistration


    private var _listaDatos =
        MutableStateFlow(mutableStateListOf<Datos>())
    var listaDatos = _listaDatos.asStateFlow()


    fun singIn( email: String, pswd: String, home: () -> Unit)
    = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, pswd)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Log.d("Felicidades", "Logueado correctamente : ${task.result.toString()}")
                        home()
                    }else{
                        Log.d("Error", "Error catch : ${task.result.toString()}")
                    }
                }
        }catch (ex:Exception){
            Log.d("Error", "Error catch : ${ex.message}")

        }
    }

    fun register(email: String, pswd:String, home: () -> Unit){
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email,pswd)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful)
                        home()
                    else{
                        Log.d("Error", "Error al iniciar sesion : ${task.result.toString()}")
                    }
                    _loading.value = false
                }

        }

    }
    fun crearListener(){
        // ponemos la oreja
        // sincrono
        conexion.collection("Datos").get()
            .addOnSuccessListener {
                it.documents
            }
        listenerReg = conexion.collection("Datos").addSnapshotListener{
                datos, error ->
            if(error == null) {
                // ¿Que cambios nuevos ha habido en la BBDD?
                datos?.documentChanges?.forEach { cambio ->
                    if(cambio.type == DocumentChange.Type.ADDED) {
                        // añadimos elemento a la lista UI
                        var nuevaDatos =  cambio.document.toObject<Datos>()
                        // me guardo el id del documento
                        nuevaDatos.idDatos = cambio.document.id
                        _listaDatos.value.add(nuevaDatos)

                    }
                    else if(cambio.type == DocumentChange.Type.REMOVED) {
                        // borramos elemento de la lista UI
                        var nuevaGrifa =  cambio.document.toObject<Datos>()
                        _listaDatos.value.remove(nuevaGrifa)
                    }
                    else if(cambio.type == DocumentChange.Type.MODIFIED) {
                        // modificamos elemento de la lista UI
                        var nuevaGrifa =  cambio.document.toObject<Datos>()
                        cambio.document.id;
                        // buscar el elemento con dicho id, y entonces borrarlo.
                        _listaDatos.value[cambio.newIndex] = nuevaGrifa
                    }

                }
            }
        }
    }

    fun borrarListener(){
        listenerReg.remove()
    }

   fun anyadirDatos(){
        var nueva = Datos("Pantalón","12.44€","https://es.dockers.com/cdn/shop/files/10428112eeeb481b1a9fa51eec89fcefaf4c1d95_540x675_crop_center.jpg?v=1701402887")
        conexion.collection("Datos").add(nueva)
    }

    fun borrarDatos(datosAborrar : Datos){
        conexion.collection("Datos")
            .document(datosAborrar.idDatos).delete()
    }

    fun actualizar(datosCambiar: Datos) {
        conexion.collection("Datos")
            .document(datosCambiar.idDatos).update("precio","5€")
    }

}

