package com.example.clase20noviembre.pantallas

import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clase20noviembre.navegacion.AppScreen

@Composable
fun FirstScreen(navController: NavController, innerPadding: PaddingValues) {
    FirstBody(navController, innerPadding)
}

@Composable
fun FirstBody(navController: NavController, innerPadding: PaddingValues) {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Introduce tus datos",
            style = TextStyle(
                fontSize = 24.sp, // Tamaño de fuente
                fontWeight = FontWeight.Bold, // Negrita
                textDecoration = TextDecoration.Underline // Subrayado
            )
        )

        // Campos de entrada
        InputField(value = nombre, onValueChange = { nombre = it }, label = "Introduce tu nombre")
        Spacer(modifier = Modifier.height(8.dp))

        InputField(value = apellidos, onValueChange = { apellidos = it }, label = "Introduce tus apellidos")
        Spacer(modifier = Modifier.height(8.dp))

        InputField(value = dni, onValueChange = { dni = it }, label = "Introduce tu DNI")
        Spacer(modifier = Modifier.height(8.dp))

        InputField(value = edad, onValueChange = { edad = it }, label = "Introduce tu edad")
        Spacer(modifier = Modifier.height(8.dp))

        InputField(value = email, onValueChange = { email = it }, label = "Introduce tu correo electrónico")
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Enviar
        SubmitButton(navController, nombre, apellidos, dni, edad, email)
    }
}

@Composable
fun InputField(value: String, onValueChange: (String) -> Unit, label: String) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun SubmitButton(
    navController: NavController,
    nombre: String,
    apellidos: String,
    dni: String,
    edad: String,
    email: String
) {
    Button(onClick = {
        when {
            // Validación Nombre
            nombre.isBlank() -> {
                showToast(navController, "El nombre no puede estar vacío")
            }
            !nombre.replace(" ", "").all { it.isLetter() } -> {
                showToast(navController, "El nombre solo puede contener letras")
            }
            nombre.length < 2 -> {  // Verificar longitud mínima
                showToast(navController, "El nombre debe tener al menos 2 caracteres")
            }

            // Validación Apellidos
            apellidos.isBlank() -> {
                showToast(navController, "Los apellidos no pueden estar vacíos")
            }
            !apellidos.replace(" ", "").all { it.isLetter() } -> {
                showToast(navController, "Los apellidos solo pueden contener letras")
            }
            apellidos.length < 2 -> {  // Verificar longitud mínima
                showToast(navController, "Los apellidos deben tener al menos 2 caracteres")
            }

            // Validación DNI
            dni.isBlank() -> {
                showToast(navController, "El DNI no puede estar vacío")
            }
            !dni.all { it.isDigit() } -> {
                showToast(navController, "El DNI debe contener solo números")
            }
            dni.length != 8 -> {  // Verificar longitud del DNI
                showToast(navController, "El DNI debe tener exactamente 8 caracteres")
            }

            // Validación Edad
            edad.isBlank() -> {
                showToast(navController, "La edad no puede estar vacía")
            }
            !edad.all { it.isDigit() } -> {
                showToast(navController, "La edad debe ser un número")
            }


            // Validación Correo Electrónico
            email.isBlank() -> {
                showToast(navController, "El correo electrónico no puede estar vacío")
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showToast(navController, "Por favor, ingresa un correo electrónico válido")
            }

            else -> {
                // Navegación a la siguiente pantalla
                navController.navigate(
                    route = AppScreen.SecondScreen.route + "/${nombre}/${apellidos}/${dni}/${edad}/${email}"
                )
            }
        }
    }) {
        Text(text = "Enviar Datos")
    }
}

fun showToast(navController: NavController, message: String) {
    Toast.makeText(
        navController.context,
        message,
        Toast.LENGTH_LONG
    ).apply {
        setGravity(Gravity.CENTER, 0, 0)
    }.show()
}
