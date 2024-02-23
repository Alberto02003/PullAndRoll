package com.example.pullandroll.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

import kotlinx.coroutines.launch

class LoginModel: ViewModel(){
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun mail() {
        val Email = mutableStateOf(0)
    }


    fun psswd(){
        val psswd = mutableStateOf(0)
    }


    fun singIn(navController: NavController, email: String, pswd: String, home: () -> Unit)
    = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, pswd)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Log.d("Felicidades", "Logueado correctamente : ${task.result.toString()}")
                        home()
                    }else{
                        navController.navigate("Cuenta")
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



}

