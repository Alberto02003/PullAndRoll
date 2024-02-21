package com.example.pullandroll.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pullandroll.R
import com.example.pullandroll.objetos.Producto

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Carrito(navController: NavController) {
    // Lista de productos
    val productos = listOf(
        Producto("Camiseta", R.drawable.tshirt, 1, 20.0),
        Producto("Pantalón", R.drawable.skirt, 2, 35.0),
        Producto("Bufanda", R.drawable.earrings, 3, 15.0),
    )

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
                items(productos) { producto ->
                    ProductoItem(producto)
                }
            }

            Button(
                onClick = { /* acción al hacer clic */ },
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 8.dp)
                    .fillMaxWidth(),
            ) {
                Text("Comprar")
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Mostrar la imagen del producto
        Image(
            painter = painterResource(id = producto.imagenResId),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        // Mostrar detalles del producto
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = producto.nombre)
            Text(text = "Cantidad: ${producto.cantidad}")
            Text(text = "Precio: $${producto.precio}")
        }

        // Mostrar el precio total del producto
        Text(
            text = "Total: $${producto.cantidad * producto.precio}",
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}
