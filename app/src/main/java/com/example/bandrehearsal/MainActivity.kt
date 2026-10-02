package com.example.bandrehearsal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bandrehearsal.adapter.MusicaAdapter
import com.example.bandrehearsal.databinding.ActivityMainBinding
import com.example.bandrehearsal.model.Musica
import com.example.bandrehearsal.storage.NotasStorage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var notasStorage: NotasStorage
    private lateinit var musicaAdapter: MusicaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notasStorage = NotasStorage(this)

        musicaAdapter = MusicaAdapter(musicasComAnotacoes()) { musica ->
            val intent = Intent(this, MetronomeActivity::class.java).apply {
                putExtra(MetronomeActivity.EXTRA_NOME_MUSICA, musica.titulo)
                putExtra(MetronomeActivity.EXTRA_BPM, musica.bpm)
                putExtra(MetronomeActivity.EXTRA_OBSERVACAO, musica.observacao)
            }
            startActivity(intent)
        }

        binding.recyclerMusicas.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = musicaAdapter
        }

        binding.tvResumo.text = getString(
            R.string.resumo_ensaio,
            MockData.musicasHoje.size
        )
    }

    /** Ao voltar da tela de anotações, o card mostra a anotação recém-salva. */
    override fun onResume() {
        super.onResume()
        musicaAdapter.atualizar(musicasComAnotacoes())
    }

    private fun musicasComAnotacoes(): List<Musica> =
        MockData.musicasHoje.map { musica ->
            musica.copy(observacao = notasStorage.obter(musica.titulo).ifBlank { null })
        }
}
