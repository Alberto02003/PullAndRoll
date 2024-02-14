package com.example.pullandroll.pantallas

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pullandroll.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Productos(navController: NavController) {
    var isDrawerOpen by remember { mutableStateOf(false) }
    val categories = listOf("Category 1", "Category 2", "Category 3", "Category 4", "Category 5")

    var selectedItemIndex by remember { mutableStateOf(-1) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("NOT P&B") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("Carrito")}) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("Perfil") }) {
                        Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Perfil de usuario")
                    }
                }

            )
        },
        content = {
            Surface(
                color = Color.Black,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    if (isDrawerOpen) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0x99000000))
                                .clickable { isDrawerOpen = false }
                        )
                        DrawerContent(closeDrawer = { isDrawerOpen = false })
                    }
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(categories) { category ->
                            Column(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                            ) {
                                Text(text = category, modifier = Modifier.padding(start = 16.dp), color = Color.White)
                                HorizontalScrollBox()
                                }
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
            .height(300.dp)
            .padding(top =90.dp)
    ) {
        items(items.size) { index ->
            Box(
                modifier = Modifier
                    .size(250.dp)
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
