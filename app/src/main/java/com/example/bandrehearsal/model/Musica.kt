package com.example.bandrehearsal.model

/**
 * Modelo imutável usado pela Etapa 1.
 * observacao é opcional e demonstra tratamento correto de valor nulo.
 */
data class Musica(
    val titulo: String,
    val tom: String,
    val bpm: Int,
    val observacao: String? = null
)
