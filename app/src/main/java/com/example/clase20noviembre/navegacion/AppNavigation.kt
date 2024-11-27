package com.example.clase20noviembre.navegacion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clase20noviembre.pantallas.FirstScreen
import com.example.clase20noviembre.pantallas.SecondScreen


@Composable
fun AppNavigation(innerPadding: PaddingValues) {
    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = AppScreen.FirstScreen.route) {
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(navControlador, innerPadding)
        }

        // Actualizar ruta para incluir los nuevos parámetros
        composable(
            AppScreen.SecondScreen.route + "/{nombre}/{apellidos}/{condicionSexual}/{edad}/{email}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("apellidos") { type = NavType.StringType },
                navArgument("condicionSexual") { type = NavType.StringType },
                navArgument("edad") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )
        ) {
            // Recibir los parámetros y pasarlos a SecondScreen
            SecondScreen(
                navControlador,
                it.arguments?.getString("nombre"),
                it.arguments?.getString("apellidos"),
                it.arguments?.getString("condicionSexual"),
                it.arguments?.getString("edad"),
                it.arguments?.getString("email"),
                innerPadding
            )
        }
    }
}
