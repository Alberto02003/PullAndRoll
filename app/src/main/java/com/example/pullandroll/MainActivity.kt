package com.example.pullandroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pullandroll.Navegacion.GrafoNavegacion
import com.example.pullandroll.ui.theme.PullAndRollTheme
import com.example.pullandroll.viewmodel.LoginModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : ComponentActivity() {
    private lateinit var databaseReference: DatabaseReference
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PullAndRollTheme{

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GrafoNavegacion()
                }
            }
        }
    }
}



