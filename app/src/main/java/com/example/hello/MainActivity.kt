 package com.example.hello

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import net.objecthunter.exp4j.ExpressionBuilder

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HELLOTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),) { innerPadding ->
                    var OperacionT by remember { mutableStateOf("") }
                    var Expresion by remember { mutableStateOf("") }
                    Column(modifier = Modifier.fillMaxWidth().padding( top = 30.dp, start = 60.dp),verticalArrangement = Arrangement.Bottom) {
                       Row (modifier = Modifier.fillMaxWidth()) {
                           TextField(value=OperacionT, onValueChange = {OperacionT=it}, readOnly = true)
                       }
                    }
                    Column(modifier = Modifier.fillMaxWidth().padding(  start = 60.dp),verticalArrangement = Arrangement.Bottom) {
                        Row {
                            BotonCalc(Texto = "7", Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="8",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="9",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="+",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })

                        }
                    Column (modifier = Modifier.fillMaxWidth().padding(start = 60.dp),verticalArrangement = Arrangement.Bottom){
                        Row {
                            BotonCalc(Texto = "4",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="5",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="6",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="-",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                        }
                    }
                    Column(modifier = Modifier.fillMaxWidth().padding( start = 60.dp),verticalArrangement = Arrangement.Bottom){
                        Row {
                            BotonCalc(Texto = "1",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="2",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="3",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="*",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                        }
                    }
                    Column(modifier = Modifier.fillMaxWidth().padding( start = 60.dp ),verticalArrangement = Arrangement.Bottom) {
                        Row {
                            BotonCalc(Texto = "C",Modifier.padding(innerPadding),{
                                OperacionT=""
                            })
                            BotonCalc(Texto = "0",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto=".",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                            BotonCalc(Texto="=",Modifier.padding(innerPadding),{
                                try{
                                    val exp= ExpressionBuilder(OperacionT).build()
                                    val eval=exp.evaluate()
                                    OperacionT=eval.toString()
                                }catch (e:Exception){
                                    OperacionT="Error"
                                }
                            })
                            BotonCalc(Texto="/",Modifier.padding(innerPadding),{
                                TextoBoton->OperacionT+=TextoBoton
                            })
                        }
                    }
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
fun BotonCalc(Texto: String,modifier: Modifier,OnBotonClick:(String)-> Unit){
    Button(
        onClick = { OnBotonClick(Texto)},
        modifier =modifier,
    ){
        Text(text = Texto)

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