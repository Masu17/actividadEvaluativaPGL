package com.aguereCoders.actividadevaluativa.service

import com.aguereCoders.actividadevaluativa.R

class DataClass {

    val listaRespuestas = listOf(
        listOf(
            true to "Todas son correctas",
            true to "One Piece",
            true to "One Piece",
            true to "One Piece"
        ),
        listOf(
            true to "Tu madre",
            false to "Huevo",
            false to "Gallina",
            false to "Jesucristo todo poderoso"
        ),
        listOf(
            true to "Un dios",
            false to "Es amor",
            false to "Es vida",
            false to "Un personaje ficticio que representa un ogro"
        ),
        listOf(
            true to "El rallo macuin",
            false to "Franchesko virgolini",
            false to "El chavo del 8",
            false to "Pedro Sanchez"
        ),
        listOf(
            true to "Tu adiccion al porno",
            false to "Vegeta",
            false to "Gohan",
            false to "Piccolo"
        ),
        listOf(
            true to "Xiaiomi",
            false to "Oppo",
            false to "Mi opinion no importa",
            false to "Iphone"
        ),
    )

    val listaPregunas = listOf(
        "¿Cual es el mejor anime del mundo?",
        "¿Cual fue primero el huevo o la gallina?",
        "¿Que es Shrek?",
        "¿Que personaje dice kachau?",
        "¿Quien es mas fuerte?",
        "¿En tu opinion cual es la mejor marca de movil calidad precio del mercado?",
    )

    val listaImagenes = listOf<Int>(
        R.drawable.juanelpiezas_photogame,
        R.drawable.tumadre_photogame,
        R.drawable.shrekdios_photogame,
        R.drawable.elrallomacuin_photogame,
        R.drawable.gokusocialista_photogame,
        R.drawable.ayaya_photogame
    )

}