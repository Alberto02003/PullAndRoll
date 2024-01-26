package com.example.pullandroll.pantallas

import android.media.browse.MediaBrowser
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.Size
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.pullandroll.R

@OptIn(UnstableApi::class)
@Composable
fun inicio(navController: NavController){
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
    }

    exoPlayer.playWhenReady = true
    exoPlayer.repeatMode = ExoPlayer.REPEAT_MODE_ALL

    val uri  = RawResourceDataSource.buildRawResourceUri(R.raw.fondo)
    val mediaItem = remember {
            MediaItem.Builder()
            .setUri(uri)
            .build()
    }
    exoPlayer.setMediaItem(mediaItem)
    exoPlayer.prepare()

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(factory = {
            PlayerView(it).apply {
                useController = false
                player = exoPlayer
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        })

        LazyVerticalGrid( columns = GridCells.Adaptive(minSize = 128.dp)){

        }



//        Column(
//            modifier = Modifier
//                .width(180.dp)
//                .height(420.dp)
//                .border(2.dp, Color.Red),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.Start
//        ) {
//                Button(modifier = Modifier.fillMaxSize(),colors = ButtonDefaults.buttonColors(
//                    contentColor = Color.Red
//                ),onClick = { /*TODO*/ }) {
//                    Text(text = "SIGN IN")
//                }
//        }
//        Column(
//            modifier = Modifier
//                .width(180.dp)
//                .height(420.dp)
//                .border(2.dp, Color.Red),
//            horizontalAlignment = Alignment.End
//        ) {
//            Button(modifier = Modifier.fillMaxSize(),colors = ButtonDefaults.buttonColors(
//                contentColor = Color.Red
//            ),onClick = { /*TODO*/ }) {
//                Text(text = "SIGN IN")
//            }
//        }

    }

}