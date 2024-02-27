<<<<<<< HEAD
# app_minha_idade
learning kotlin, first app
=======
# Aplicativo de Informação de Idade

Este é um aplicativo simples desenvolvido para fins de aprendizado e prática. Ele permite que o usuário informe sua idade pressionando os botões de "+" e "-", e a idade é exibida na tela.

## Descrição

Este é um projeto inicial e simples, destinado a explorar conceitos básicos de desenvolvimento de aplicativos Android usando o framework Jetpack Compose.

## Funcionalidades Principais

- Permite ao usuário aumentar ou diminuir a idade pressionando os botões "+" e "-".
- Exibe a idade atualizada na tela.

## Tecnologias Utilizadas

- Linguagem de programação: Kotlin
- Framework: Jetpack Compose
- Ambiente de Desenvolvimento: Android Studio

## Como Utilizar

1. Abra o aplicativo em um dispositivo Android compatível.
2. Pressione os botões "+" e "-" para aumentar ou diminuir a idade.
3. A idade atualizada será exibida na tela.

## Código-fonte

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}

@Composable
fun CounterScreen(){
    var idade = remember { mutableIntStateOf(value = 0) }

    Column(modifier = Modifier
        .padding(36.dp)
        .fillMaxWidth()) {
        // Textos e espaçamentos...
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "${idade.value}",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        // Botões de "+" e "-"...
    }
}
>>>>>>> origin/master
