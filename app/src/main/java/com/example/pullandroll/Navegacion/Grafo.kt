package com.example.pullandroll.Navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pullandroll.Rutas.Rutas
import com.example.pullandroll.pantallas.inicio


@Composable
fun GrafoNavegacion(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.inicio.ruta){
        composable(Rutas.inicio.ruta){
            inicio(navController = navController)
        }




    }

}