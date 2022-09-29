package onur.ugur.jetpackcomposecheetsheet.dottedShape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import onur.ugur.jetpackcomposecheetsheet.ui.theme.DottedShape

@Composable
fun DottedShape() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)) {

        Row(modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp), verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Hello There", modifier = Modifier.padding(end = 8.dp), color = Color.Black)

            Box(
                contentAlignment = Alignment.BottomCenter, modifier = Modifier
                    .weight(1f)
                    .height(10.dp)
            ) {

                Spacer(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color.Blue,
                            shape = DottedShape(step = 4.dp)
                        )
                )

            }

            Text(text = "End Of The Text", modifier = Modifier.padding(start = 8.dp), color = Color.Cyan)

        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 42.dp, start = 12.dp, end = 12.dp)) {

            Spacer(
                modifier = Modifier
                    .height(22.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Blue,
                        shape = DottedShape(step = 22.dp)
                    )
            )

        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 42.dp, start = 12.dp, end = 12.dp)) {

            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Blue,
                        shape = DottedShape(step = 16.dp)
                    )
            )

        }


    }
}