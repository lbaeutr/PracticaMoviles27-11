package com.example.clase20noviembre.navegacion

import android.media.MediaRouter

sealed class AppScreen(val route: String) {

    object FirstScreen : AppScreen("FirstScreen")
    object SecondScreen : AppScreen("SecondScreen")


}