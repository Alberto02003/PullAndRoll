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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pullandroll.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreNosotros(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sobre nosotros") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("Perfil") }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Ir atras"
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sobre NOT P&B"
                )
                Text(
                    text = "Desarrolladores: Alberto Martín Morín y Daniel Palenzuela Álvarez 2 DAM B"
                )
                Text(
                    text = "última versión más estable: 2.0 (2024)"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "\"Somos un equipo respaldado por una amplia experiencia en el" +
                            " desarrollo y gestión de aplicaciones para comercio digital. Desde expertos en " +
                            "diseño de interfaz hasta informaticos altamente capacitados, trabajamos en " +
                            "sinergia para ofrecer una plataforma de compras en línea de primera clase. Nos dedicamos a " +
                            "proporcionar una experiencia fluida y segura para nuestros usuarios, combinando habilidades " +
                            "técnicas con una comprensión profunda de las tendencias del mercado y las necesidades de nuestros " +
                            "clientes en el ámbito de la moda. Nuestro compromiso es ofrecer una experiencia de compra excepcional " +
                            "que refleje nuestra pasión por la excelencia y la innovación en el comercio digital de moda.",
                    modifier = Modifier.width(300.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProfilePhoto(imageResource = R.drawable.ic_launcher_background)
                    ProfilePhoto(imageResource = R.drawable.ic_launcher_background)
                    ProfilePhoto(imageResource = R.drawable.ic_launcher_background)
                }
            }
        }
    )
}

@Composable
fun ProfilePhoto(imageResource: Int) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}
