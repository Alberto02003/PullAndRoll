package com.example.pullandroll.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.pullandroll.R
import com.example.pullandroll.objetos.Datos

import com.example.pullandroll.viewmodel.LoginModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Carrito(navController: NavController) {

    var viewModel : LoginModel = viewModel()
    val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference()


    DisposableEffect(key1 = viewModel){
        viewModel.crearListener()
        onDispose { viewModel.borrarListener() }
    }

    var listaDatosUI = viewModel.listaDatos.collectAsState().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Menu hamburguesa") },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu hamburguesa")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn {
                items(listaDatosUI) { producto ->
                    ProductoItem(producto,viewModel)
                }
            }

            Button(
                onClick = { viewModel.anyadirDatos() },
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 8.dp)
                    .fillMaxWidth(),
            ) {
                Text("Añadir")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductoItem(producto: Datos,viewModel: LoginModel) {
    val imagePainter = rememberImagePainter(data = producto.Imagen)
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = { viewModel.actualizar(producto) },
                onLongClick = { viewModel.borrarDatos(producto) }
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Mostrar la imagen del producto
        Image(
            painter = imagePainter,
            contentDescription = "",
            modifier = Modifier.size(64.dp)
        )

        // Mostrar detalles del producto
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Cantidad: ${producto.Nombre}")
            Text(text = "Precio: $${producto.Precio}")
        }



    }

}
