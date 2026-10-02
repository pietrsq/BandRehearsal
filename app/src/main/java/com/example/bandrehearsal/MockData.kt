package com.example.bandrehearsal

import com.example.bandrehearsal.model.Musica

object MockData {
    val musicasHoje = listOf(
        Musica(
            titulo = "Drain You",
            tom = "A",
            bpm = 134,
            observacao = "Acertar a dinâmica antes do refrão"
        ),
        Musica(
            titulo = "Interstate Love Song",
            tom = "E",
            bpm = 84,
            observacao = "Revisar entrada da segunda guitarra"
        ),
        Musica(
            titulo = "Black Hole Sun",
            tom = "G",
            bpm = 105,
            observacao = null
        ),
        Musica(
            titulo = "Would?",
            tom = "F#",
            bpm = 101,
            observacao = "Treinar virada antes do último refrão"
        )
    )
}
