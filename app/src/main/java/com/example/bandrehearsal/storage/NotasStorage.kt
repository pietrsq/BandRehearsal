package com.example.bandrehearsal.storage

import android.content.Context

/**
 * Guarda a anotação de texto livre de cada música no armazenamento interno do app
 * (SharedPreferences). Cada música tem a sua própria chave, então as anotações
 * não se misturam. Um texto vazio é um valor válido (a pessoa apagou tudo).
 */
class NotasStorage(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE)

    fun obter(tituloMusica: String): String =
        prefs.getString(chave(tituloMusica), "") ?: ""

    fun salvar(tituloMusica: String, texto: String) {
        prefs.edit().putString(chave(tituloMusica), texto).apply()
    }

    private fun chave(tituloMusica: String) = "nota_$tituloMusica"

    private companion object {
        const val NOME_ARQUIVO = "anotacoes_musicas"
    }
}
