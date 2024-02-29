package br.com.fiap.minhaidade
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
//                    Greeting("Android")
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CounterScreenPreview() {
    MinhaIdadeTheme {
        CounterScreen()
    }
}

@Composable
fun CounterScreen(){

    var idade = remember {
        mutableIntStateOf(value = 0)
    }

    var resultado = remember {
        mutableStateOf(value = "Resultado")
    }

    Column(modifier = Modifier
        .padding(36.dp)
        .fillMaxWidth()) {
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Qual sua idade ?",
            fontSize = 24.sp,
            color = Color.Companion.Red,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Aperte os botões para informar a sua idade.",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            )
        Spacer(modifier = Modifier.height(14.dp))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "${idade.value}",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(22.dp))

        Row (horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            ){

            Button(
                onClick = {
                    if (idade.intValue > 0){
                    idade.intValue-- }
                    if (idade.intValue >= 18) {
                        resultado.value = "Você é maior de idade."
                    } else if (idade.value < 18 && idade.value > 0){
                        resultado.value = "Você é menor de idade."
                    }
                    if (idade.intValue == 0){
                        resultado.value = "Resultado"
                    }
                },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFaD1F4E)),
                ) {
                Text(
                    text = "-",
                    fontSize = 40.sp)
            }

            Spacer(modifier = Modifier.width(26.dp))

            Button(
                onClick = {
                    if (idade.intValue < 131){
                    idade.intValue++}
                    if (idade.intValue >= 18) {
                        resultado.value = "Você é maior de idade."
                    } else if (idade.value < 18 && idade.value > 0){
                        resultado.value = "Você é menor de idade."
                    }
                    if (idade.intValue == 0){
                        resultado.value = "Resultado"
                    }
                },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFaD1F4E))
                ) {
                Text(
                    text = "+",
                    fontSize = 40.sp)
                }
            }
        Column (modifier = Modifier
            .padding(36.dp)
            .fillMaxWidth()) {
            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = "${resultado.value}",
                fontSize = 24.sp,
                color = Color.Companion.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(22.dp))
        }
        }
    }

