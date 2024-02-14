package com.example.pullandroll.Rutas

sealed class Rutas(val ruta: String){
    object Inicio : Rutas("Inicio")
    object Cuenta : Rutas("Cuenta")
    object Productos : Rutas("Productos")
    object Carrito : Rutas("Carrito")
    object Registro : Rutas("Registro")
    object SobreNosotros : Rutas("SobreNosotros")
    object Perfil : Rutas("Perfil")
}