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

    private var _listaGrifa = MutableStateFlow(mutableStateListOf<Camiseta_Negra>())
    var listaGrifa = _listaGrifa.asStateFlow()

    fun crearListener(){
        cn.collection("Camiseta_Negra").addSnapshotListener{
            datos,error ->
            if (error == null){
                datos?.documentChanges?.forEach { cambio ->
                 if (cambio.type == DocumentChange.Type.ADDED){
                     var nuevaGrifa = cambio.document.toObject<Camiseta_Negra>()
                     _listaGrifa.value.add(nuevaGrifa)
                 }
                 else if (cambio.type == DocumentChange.Type.REMOVED){
                     var nuevaGrifa = cambio.document.toObject<Camiseta_Negra>()
                     _listaGrifa.value.remove(nuevaGrifa)
                 }
                 else if (cambio.type == DocumentChange.Type.MODIFIED){
                     var nuevaGrifa = cambio.document.toObject<Camiseta_Negra>()
                     _listaGrifa.value[cambio.newIndex] = nuevaGrifa
                 }
                }
            }
        }
    }
    fun BorrarListener(){
        listenerReg.remove()
    }
}

