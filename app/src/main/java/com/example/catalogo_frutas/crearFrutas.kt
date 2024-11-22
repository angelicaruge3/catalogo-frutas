package com.example.catalogo_frutas

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun <InfoFrutas> crearFrutas(navController: NavController, usuarios: SnapshotStateList<ClaseFrutas>) {

    var nombre by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf("") }

    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Frutas",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize =  20.sp
        )

        Spacer(modifier = Modifier.size(16.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = {
                Text(text = "Digite el nombre de la fruta")
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        TextField(
            value = codigo,
            onValueChange = { codigo = it },
            label = {
                Text(text = "Digite el codigo de la fruta")
            } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number )
        )

        Spacer(modifier = Modifier.size(16.dp))

        TextField(
            value = imagen,
            onValueChange = { imagen = it },
            label = {
                Text(text = "Agregue el url de la imagen")
            },

            modifier = Modifier.width(280.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = {

            if (nombre.isNotBlank() && codigo.isNotBlank() && imagen.isNotBlank()) {
                val nuevaFrutas = ClaseFrutas(nombre, codigo, imagen)
                usuarios.add(nuevaFrutas)
                navController.navigate("ListaFrutas")
            } else {

                Toast.makeText(context,"Completa todos los campos antes de agregar", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Agregar")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = {

            navController.navigate("ListaFrutas")
        }) {
            Text(text = "Listar")
        }

    }
}

private fun <E> MutableList<E>.add(element: ClaseFrutas) {

}



