package com.example.pullandroll.Rutas

sealed class Rutas(val ruta: String){
    object Inicio : Rutas("Inicio")
    object Cuenta : Rutas("Cuenta")
    object Accesorios : Rutas("Accesorios")
    object Carrito : Rutas("Carrito")
    object Registro : Rutas("Registro")
    object RopaHombre : Rutas("RopaHombre")
    object RopaMujer : Rutas("RopaMujer")
    object SobreNosotros : Rutas("SobreNosotros")
    object Perfil : Rutas("Perfil")
}