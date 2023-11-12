package com.aguereCoders.actividadevaluativa.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.aguereCoders.actividadevaluativa.R
import com.aguereCoders.actividadevaluativa.navigation.Rutas

@Composable
fun LevelSelect(navController: NavHostController) {

    Image(
        painter = painterResource(R.drawable.questions_background),
        contentDescription = "background image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Niveles",
                fontSize = 30.sp,
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
                    .background(Color(179, 145, 112), RoundedCornerShape(50.dp))
                    .border(2.dp, Color.Black, RoundedCornerShape(50.dp))
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp)
            )
            LevelColums(navController = navController)
        }
        Button(
            onClick = { navController.navigate(Rutas.Principal.ruta) },
            Modifier.fillMaxWidth()
        ) {
            Text(text = "Menu principal")
        }
    }


}

@Composable
fun LevelColums(navController: NavController) {
    var iterator = 1;
    val numColumnas = 3
    for (i in 1..2) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (j in 1..numColumnas) {
                val nivelSeleccionado = (i - 1) * numColumnas + j
                Box(
                    modifier = Modifier
                        .padding(3.dp)
                        .width(100.dp)
                        .height(100.dp)
                        .background(Color(179, 145, 112), RoundedCornerShape(10.dp))
                        .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                ) {
                    TextButton(
                        onClick = {
                            navController.navigate(Rutas.Juego.ruta + "/${nivelSeleccionado}")
                        },
                        modifier = Modifier
                            .background(Color.Transparent)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Nivel $iterator",
                            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                            fontSize = 20.sp
                        )
                    }
                }
                iterator++;
            }
        }
    }
}

