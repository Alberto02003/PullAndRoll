package com.example.pullandroll.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavController
import com.example.pullandroll.R
import com.example.pullandroll.objetos.Producto


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Productos(navController: NavController) {

   /* val productos = listOf(
        Producto("Camiseta", R.drawable.tshirt, 1, 20.0),
        Producto("Pantalón", R.drawable.skirt, 2, 35.0),
        Producto("Bufanda", R.drawable.earrings, 3, 15.0),
    )
    Carrito(navController = navController, productos = productos, onBuyClicked = {
        // Acción al hacer clic en el botón de comprar
    })*/
    var isDrawerOpen by remember { mutableStateOf(false) }
    val categories = listOf("Category 1", "Category 2", "Category 3", "Category 4", "Category 5")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("NOT P&B") },
                navigationIcon = {
                    IconButton(onClick = {
                        isDrawerOpen = true
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(categories) { category ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        ) {
                            Text(
                                text = category,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                            HorizontalScrollBox()
                        }
                    }
                }
            }
        }
    )

}



@Composable
fun HorizontalScrollBox() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 8.dp)
    ) {
        items(items.size) { index ->
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .padding(horizontal = 8.dp)
                    .background(Color.Gray)
            ) {
                Text(
                    text = items[index],
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun DrawerContent(closeDrawer: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Menu Item 1", modifier = Modifier.clickable { closeDrawer() })
        Spacer(modifier = Modifier.height(16.dp))
        Text("Menu Item 2", modifier = Modifier.clickable { closeDrawer() })
        Spacer(modifier = Modifier.height(16.dp))
        Text("Menu Item 3", modifier = Modifier.clickable { closeDrawer() })
    }
}

