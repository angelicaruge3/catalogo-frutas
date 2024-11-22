package com.example.catalogo_frutas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){

    val navController = rememberNavController()

    val frutas = remember { mutableStateListOf<ClaseFrutas>() }


    NavHost(navController = navController, startDestination = "CrearFrutas" ) {

        composable("CrearFrutas"){
            crearFrutas<Any?>(navController, frutas)
        }

        composable("ListaFrutas"){
            ListaFrutas<Any?>(navController, frutas)
        }


    }

}

