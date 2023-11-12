package com.aguereCoders.actividadevaluativa.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aguereCoders.actividadevaluativa.components.Level
import com.aguereCoders.actividadevaluativa.components.LevelSelect
import com.aguereCoders.actividadevaluativa.components.MainMenu

@Composable
fun GrafoNav() {
    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = Rutas.Principal.ruta) {

        composable(Rutas.Principal.ruta) {
            MainMenu(navController)
        }
        composable(Rutas.Niveles.ruta) {
            LevelSelect(navController)
        }
        composable(Rutas.Juego.ruta + "/{level}") {
            val level = it.arguments?.getString("level")?.toInt() ?: 1
            Level(navController, level)
        }

    }

}
