package com.example.pullandroll.Navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pullandroll.Rutas.Rutas
/*import com.example.pullandroll.pantallas.Carrito*/
import com.example.pullandroll.pantallas.Cuenta
import com.example.pullandroll.pantallas.Inicio
import com.example.pullandroll.pantallas.Perfil
import com.example.pullandroll.pantallas.Productos
import com.example.pullandroll.pantallas.Registro
import com.example.pullandroll.pantallas.SobreNosotros


@Composable
fun GrafoNavegacion(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.Inicio.ruta){
        composable(Rutas.Inicio.ruta){
            Inicio(navController = navController)
        }
        composable(Rutas.Cuenta.ruta){
            Cuenta(navController = navController)
        }
        /*composable(Rutas.Carrito.ruta){
            Carrito(navController = navController)
        }*/
        composable(Rutas.Productos.ruta){
            Productos(navController = navController)
        }
        composable(Rutas.Registro.ruta){
            Registro(navController = navController)
        }
        composable(Rutas.SobreNosotros.ruta){
            SobreNosotros(navController = navController)
        }
        composable(Rutas.Perfil.ruta){
            Perfil(navController = navController)
        }


    }

}