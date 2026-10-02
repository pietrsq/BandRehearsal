package com.example.bandrehearsal

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.bandrehearsal.storage.NotasStorage

class MetronomeActivity : AppCompatActivity() {

    private var bpmAtual = 120

    private lateinit var notasStorage: NotasStorage
    private lateinit var etAnotacoes: EditText
    private lateinit var nomeMusica: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metronome)

        val tvNomeMusica = findViewById<TextView>(R.id.tvNomeMusica)
        val tvBpm = findViewById<TextView>(R.id.tvBpm)
        etAnotacoes = findViewById(R.id.etAnotacoes)
        val btnMenos = findViewById<Button>(R.id.btnMenos)
        val btnMais = findViewById<Button>(R.id.btnMais)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        nomeMusica = intent.getStringExtra(EXTRA_NOME_MUSICA)
            ?: getString(R.string.musica_sem_nome)

        bpmAtual = intent.getIntExtra(EXTRA_BPM, 120)

        notasStorage = NotasStorage(this)

        tvNomeMusica.text = nomeMusica
        etAnotacoes.setText(notasStorage.obter(nomeMusica))

        // Com edge-to-edge (Android 15+) o teclado não redimensiona a tela sozinho:
        // aplicamos a altura do teclado como padding para o campo não ficar escondido.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById<View>(R.id.scrollRoot)) { view, insets ->
            val ime = insets.getInsets(WindowInsetsCompat.Type.ime())
            view.updatePadding(bottom = ime.bottom)
            insets
        }

        fun atualizarBpmNaTela() {
            tvBpm.text = getString(R.string.bpm_formatado, bpmAtual)
        }

        atualizarBpmNaTela()

        btnMenos.setOnClickListener {
            if (bpmAtual > 1) {
                bpmAtual--
                atualizarBpmNaTela()
            }
        }

        btnMais.setOnClickListener {
            bpmAtual++
            atualizarBpmNaTela()
        }

        btnSalvar.setOnClickListener {
            salvarAnotacao()
            etAnotacoes.clearFocus()
            getSystemService(InputMethodManager::class.java)
                ?.hideSoftInputFromWindow(etAnotacoes.windowToken, 0)
            Toast.makeText(this, R.string.anotacao_salva, Toast.LENGTH_SHORT).show()
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    /** Salva automaticamente ao sair da tela (voltar, botão Home, rotação etc.). */
    override fun onPause() {
        super.onPause()
        salvarAnotacao()
    }

    private fun salvarAnotacao() {
        notasStorage.salvar(nomeMusica, etAnotacoes.text.toString())
    }

    companion object {
        const val EXTRA_NOME_MUSICA = "extra_nome_musica"
        const val EXTRA_BPM = "extra_bpm"
        const val EXTRA_OBSERVACAO = "extra_observacao"
    }
}
