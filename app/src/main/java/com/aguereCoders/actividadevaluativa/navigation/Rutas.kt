package com.aguereCoders.actividadevaluativa.navigation

sealed class Rutas(val ruta: String){
    object Principal: Rutas("principal")
    object Niveles: Rutas("niveles")
    object Juego: Rutas("juego")
}
