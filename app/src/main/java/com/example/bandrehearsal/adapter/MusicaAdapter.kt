package com.example.bandrehearsal.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bandrehearsal.databinding.ItemMusicaBinding
import com.example.bandrehearsal.model.Musica

class MusicaAdapter(
    private var musicas: List<Musica>,
    private val onMusicaClick: (Musica) -> Unit
) : RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder>() {

    inner class MusicaViewHolder(
        private val binding: ItemMusicaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(musica: Musica) {
            binding.tvTtituloPlaceholder()
            binding.tvTitulo.text = musica.titulo
            binding.tvTomBpm.text = "Tom ${musica.tom}  •  ${musica.bpm} BPM"
            binding.tvObservacao.text = musica.observacao ?: "Sem anotações para esta música"

            binding.root.setOnClickListener {
                onMusicaClick(musica)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun atualizar(novasMusicas: List<Musica>) {
        musicas = novasMusicas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicaViewHolder {
        val binding = ItemMusicaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicaViewHolder, position: Int) {
        holder.bind(musicas[position])
    }

    override fun getItemCount(): Int = musicas.size
}
