 package com.example.hello

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.HELLOTheme

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HELLOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var textoCuadro1 by remember{mutableStateOf("")}
                    var textoCuadro2 by remember{mutableStateOf("")}
                    var textoCuadro3 by remember{mutableStateOf("")}
                    Column(modifier = Modifier.fillMaxWidth().padding( horizontal = 30.dp )) {

                        Spacer(modifier = Modifier.width(16.dp).height(30.dp))
                        Cuadro(
                            modifier = Modifier.padding(innerPadding),
                            Texto = textoCuadro1,
                            OnTextoChange = { textoCuadro1 = it }

                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Cuadro(
                            modifier = Modifier.padding(horizontal = 0.dp, vertical = 30.dp),
                            Texto = textoCuadro2,
                            OnTextoChange = { textoCuadro2 = it }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                val suma = textoCuadro1.toInt() + textoCuadro2.toInt()
                                textoCuadro3 = suma.toString()
                            },
                            content = { Text(text = "Suma") }
                        )
                        Cuadro(
                            modifier = Modifier.padding(horizontal = 0.dp, vertical = 30.dp),
                            Texto = textoCuadro3,
                            OnTextoChange = { textoCuadro3 = it }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Esto es una prueba $name!",
        modifier = modifier
    )
}

@Composable
fun Boton(modifier: Modifier = Modifier,Contenido:String){
    Button(onClick = {

    },  ) {
        Text(Contenido)
    }
}
 @Composable
 fun Cuadro(modifier: Modifier= Modifier,Texto: String,OnTextoChange:(String)-> Unit){
    TextField(
        value = Texto,
        onValueChange =OnTextoChange,
        modifier=modifier
    )
 }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HELLOTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            var textoCuadro1 by remember { mutableStateOf("") }
            var textoCuadro2 by remember { mutableStateOf("") }
            Column(modifier = Modifier.padding(innerPadding)) {
            }
        }
    }
}