package com.aguereCoders.actividadevaluativa.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aguereCoders.actividadevaluativa.MainActivity
import com.aguereCoders.actividadevaluativa.R
import com.aguereCoders.actividadevaluativa.navigation.Rutas

@Composable
fun MainMenu(navController: NavController) {

    val contexto = LocalContext.current

    Image(
        painter = painterResource(R.drawable.questions_background),
        contentDescription = "background image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
        )
        Text(
            text = "Pregunta-2",
            fontSize = 30.sp,
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .background(Color(179, 145, 112), RoundedCornerShape(50.dp))
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
        ButtonPrincipal(texto = "Jugar") {
            navController.navigate(Rutas.Niveles.ruta)
        }
        ButtonPrincipal(texto = "Versus") {
            Toast.makeText(
                contexto,
                "El modo de juego Versus no esta disponible",
                Toast.LENGTH_SHORT
            ).show()
            //TODO crear el modo de juego Versus
            //TODO Crear un sistema de historial en un fichero
        }
        ButtonPrincipal(texto = "Historial") {
            Toast.makeText(
                contexto,
                "El historial se encuentra en desarrollo",
                Toast.LENGTH_SHORT
            ).show().toString()
            //TODO Diseñar el historial y añadir la navegacion
            //TODO recuperar el historial del fichero
        }
    }
}

@Composable
fun ButtonPrincipal(texto: String, funcion: () -> Unit) {
    Button(
        onClick = {
            funcion.invoke()
        },
        Modifier
            .width(230.dp)
            .height(65.dp)
            .padding(6.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(50.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(179, 145, 112))
    ) {
        Text(text = "$texto", fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}

