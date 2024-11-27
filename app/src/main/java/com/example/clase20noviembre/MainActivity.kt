package com.example.clase20noviembre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clase20noviembre.navegacion.AppNavigation
import com.example.clase20noviembre.pantallas.FirstScreen
import com.example.clase20noviembre.ui.theme.Clase20NoviembreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Clase20NoviembreTheme {
                Scaffold { innerPadding ->
                    AppNavigation(innerPadding)
                }
            }
        }
    }
}
