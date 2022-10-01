package onur.ugur.jetpackcomposecheetsheet.onLongPress

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun Modifier.onLongPress(
    millisInFuture: Long = 30000,
    countDownInterval: Long = 200,
    onReturn: () -> Unit
): Modifier {
    val timer = object : CountDownTimer(millisInFuture, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {
            onReturn()
        }

        override fun onFinish() {}
    }

    return this.pointerInput(Unit) {
        forEachGesture {
            awaitPointerEventScope {
                awaitFirstDown()
                timer.start()
                do {
                    val event = awaitPointerEvent()
                } while (event.changes.any { it.pressed })
                timer.cancel()
            }
        }
    }
}

@Composable
fun onLongPressText() {

    var input by remember { mutableStateOf(1) }

    Column(
        Modifier
            .fillMaxSize().padding(start = 12.dp)
            .background(Color.White)
    ) {

        Text(
            text = input.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
            style = TextStyle(
                fontSize = 20.sp
            )
        )

        Text(text = "Increase Number", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .onLongPress {
                input ++
            })

        Text(text = "Decrease Number", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .onLongPress {
                input --
            })

    }
}
