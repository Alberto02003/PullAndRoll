package com.example.pullandroll.pantallas/*
package com.example.pullandroll.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pullandroll.R
import com.example.pullandroll.objetos.Producto

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Carrito(navController: NavController, productos: List<Producto>, onBuyClicked: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Carrito de Compra") },
                actions = {
                    IconButton(onClick = { */
/* acción al hacer clic *//*
 }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito de compra")
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
                onClick = onBuyClicked,
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
}*/
