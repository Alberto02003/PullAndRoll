package com.example.pullandroll.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pullandroll.cn.Camiseta_Negra

import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.w3c.dom.DocumentType

class ViewModelFirebase: ViewModel(){

    //conexion
    val cn = FirebaseFirestore.getInstance()
    private lateinit var listenerReg : ListenerRegistration

    private var _Camiseta_Negra = MutableStateFlow(mutableStateListOf<Camiseta_Negra>())
    var camiseta_negra = _Camiseta_Negra.asStateFlow()

    fun crearListener(){
        cn.collection("Camiseta_Negra").addSnapshotListener{
            datos,error ->
            if (error == null){
                datos?.documentChanges?.forEach { cambio ->
                 if (cambio.type == DocumentChange.Type.ADDED){
                     var nuevaGcamiseta = cambio.document.toObject<Camiseta_Negra>()
                     _Camiseta_Negra.value.add(nuevaGcamiseta)
                 }
                 else if (cambio.type == DocumentChange.Type.REMOVED){
                     var nuevaGcamiseta = cambio.document.toObject<Camiseta_Negra>()
                     _Camiseta_Negra.value.remove(nuevaGcamiseta)
                 }
                 else if (cambio.type == DocumentChange.Type.MODIFIED){
                     var nuevaGcamiseta = cambio.document.toObject<Camiseta_Negra>()
                     _Camiseta_Negra.value[cambio.newIndex] = nuevaGcamiseta
                 }
                }
            }
        }
    }
    fun BorrarListener(){
        listenerReg.remove()
    }
}

