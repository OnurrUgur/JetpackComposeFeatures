package onur.ugur.jetpackcomposecheetsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import onur.ugur.jetpackcomposecheetsheet.ui.theme.DottedShape
import onur.ugur.jetpackcomposecheetsheet.ui.theme.JetpackComposeCheetSheetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCheetSheetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    DottedShapedText()

                }
            }
        }
    }
}

@Composable
fun DottedShapedText() {
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCheetSheetTheme {
        DottedShapedText()
    }
}