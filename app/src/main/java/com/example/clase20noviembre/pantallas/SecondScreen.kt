package com.example.clase20noviembre.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondScreen(
    navController: NavController,
    nombre: String?,
    apellidos: String?,
    dni: String?,
    edad: String?,
    email: String?,
    innerPadding: PaddingValues
) {
    SecondBody(navController, nombre, apellidos, dni, edad, email, innerPadding)
}

@Composable
fun SecondBody(
    navController: NavController,
    nombre: String?,
    apellidos: String?,
    dni: String?,
    edad: String?,
    email: String?,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Sombra
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                nombre?.let {
                    Text(
                        text = "¡Bienvenido, $it!",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6200EE),
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }

                nombre?.let {
                    Text(
                        text = "Nombre: $it",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                apellidos?.let {
                    Text(
                        text = "Apellidos: $it",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                dni?.let {
                    Text(
                        text = "DNI: $it",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                edad?.let {
                    Text(
                        text = "Edad: $it",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                email?.let {
                    Text(
                        text = "Correo electrónico: $it",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("De vuelta", color = Color.White, fontSize = 16.sp)
        }
    }
}
