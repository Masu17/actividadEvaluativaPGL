package com.aguereCoders.actividadevaluativa.components

import android.provider.ContactsContract.Data
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aguereCoders.actividadevaluativa.R
import com.aguereCoders.actividadevaluativa.navigation.Rutas
import com.aguereCoders.actividadevaluativa.service.DataClass

@Composable
fun Level(navControler: NavHostController, level: Int) {

    var isEnabledButton by remember {
        mutableStateOf(true)
    }

    val shuffledOptions = remember {
        if (isEnabledButton) {
            DataClass().listaRespuestas[level - 1].get(0)
                ?.let { DataClass().listaRespuestas[level - 1].shuffled() } ?: emptyList()
        } else {
            DataClass().listaRespuestas[level - 1]
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(184, 180, 212)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )
            Text(
                text = "Nivel $level",
                fontSize = 46.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
            Image(
                painter = painterResource(DataClass().listaImagenes[level - 1]),
                contentDescription = "avatar",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(180.dp)
                    .width(350.dp)
                    .clip(RectangleShape)
                    .background(Color.Black)
            )
            Text(
                text = DataClass().listaPregunas[level - 1],
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
            )

            if (isEnabledButton) {
                isEnabledButton =
                    createBotones(isEnabled = isEnabledButton, shuffledOptions = shuffledOptions)
            } else {
                createBotones(isEnabled = isEnabledButton, shuffledOptions = shuffledOptions)
            }

        }
        Button(onClick = { navControler.navigate(Rutas.Niveles.ruta) }) {
            Text(
                text = "Volver al inicio",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun createBotones(isEnabled: Boolean, shuffledOptions: List<Pair<Boolean, String>>): Boolean {

    var updateIsEnabled by remember {
        mutableStateOf(isEnabled)
    }

    if (isEnabled) {
        shuffledOptions.forEach {
            Button(
                onClick = { updateIsEnabled = false },
                modifier = Modifier
                    .width(300.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(50.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(179, 145, 112))
            ) {
                Text(
                    text = it.second,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )
        }
    } else {
        shuffledOptions.forEach {
            if (it.first) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(76, 224, 179)),
                    modifier = Modifier.width(300.dp)
                ) {
                    Text(text = it.second, fontSize = 20.sp, textAlign = TextAlign.Center)

                }
            } else {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(249, 112, 104)),
                    modifier = Modifier.width(300.dp)
                ) {
                    Text(text = it.second, fontSize = 20.sp, textAlign = TextAlign.Center)
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )
        }
    }
    return updateIsEnabled
}


