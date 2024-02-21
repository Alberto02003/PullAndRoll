package com.example.pullandroll.pantallas

import android.annotation.SuppressLint
import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pullandroll.R
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Perfil(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileInfo(
            name = "John Doe",
            correo = "Alberto el puto",
            contraseña = "Software Engineer"
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChangePasswordButton(onClick = {  })
        Button(
            modifier = Modifier
                .fillMaxSize(),
            colors = ButtonDefaults.buttonColors(),
            onClick = { navController.navigate("SobreNosotros") }
        ) {
            Text(text = "Sobre Nosotros")
        }
    }
}

@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.fotoperfil),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(150.dp)
            .padding(8.dp),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,

    )
}

@Composable
fun ProfileInfo(name: String, correo: String, contraseña: String) {
    Text(
        text = name,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Correo: $correo",
        fontSize = 16.sp,
        color = Color.Gray
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Contraseña: $contraseña",
        fontSize = 16.sp,
        color = Color.Gray
    )
}

@Composable
fun ChangePasswordButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Cambiar Contraseña")
    }
}