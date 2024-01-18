package com.example.pullandroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pullandroll.ui.theme.PullAndRollTheme
import com.example.pullandroll.viewmodel.ViewModelFirebase


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PullAndRollTheme{

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var viewModelFirebase : ViewModelFirebase = viewModel()

                    val camisetaNegra = viewModelFirebase.camiseta_negra.collectAsState().value

                    DisposableEffect(key1 = viewModelFirebase){
                        viewModelFirebase.crearListener()
                        onDispose { viewModelFirebase.BorrarListener()}
                    }

                    LazyColumn() {
                        items(camisetaNegra){
                            Text(it.toString())
                        }
                    }
                    Row(verticalAlignment = Alignment.Bottom) {
                       FloatingActionButton( modifier = Modifier.padding(20.dp), onClick = { /*TODO*/ }) {
                           Text(text = "Agregar")
                       }
                    }
                }
            }
        }
    }
}



