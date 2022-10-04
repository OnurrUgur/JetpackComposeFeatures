package onur.ugur.jetpackcomposecheetsheet.zIndex

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun ZIndexFeature() {

    var openPage = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(0f)
            .background(color = Color.White)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Text(text = "Test text for z index")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Test text for z index")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            TextButton(onClick = { openPage.value = true }) {

                Text(text = "Open Z Index Page")

            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Test text for z index")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Test text for z index")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Test text for z index")

        }

    }

    AnimatedVisibility(
        visible = openPage.value, exit = fadeOut(animationSpec = tween(300, easing = LinearEasing)),
        enter = fadeIn(animationSpec = tween(500, easing = LinearEasing)), modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                openPage.value = false

            }
    ) {

        SecondPage(onCloseClick = { openPage.value = false })

    }
}

@Composable
fun SecondPage(onCloseClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.6f))
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(all = 32.dp)
                .background(color = Color.White)
                .clickable { }

        ) {

            Text(text = "Second Page Test")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            TextField(value = "Test for z index", onValueChange ={} )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Second Page Test")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Second Page Test")

            Spacer(modifier = Modifier.padding(top = 22.dp))

            TextButton(onClick = { onCloseClick() }, modifier = Modifier.fillMaxWidth()) {

                Text(text = "To Close Tap Here")
            }

        }
    }
}