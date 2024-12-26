package com.dicoding.chelseaicon

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.chelseaicon.databinding.ItemRowPlayersBinding

class ListPlayersAdapter(private val listPlayers: ArrayList<Players>) : RecyclerView.Adapter<ListPlayersAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowPlayersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val player = listPlayers[position]
        holder.bind(player)
    }

    override fun getItemCount(): Int = listPlayers.size

    class ListViewHolder(private val binding: ItemRowPlayersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Players) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(player.photo)
                    .into(imgItemPhoto)

                tvItemName.text = player.name

                val combinedText = buildString {
                    append("Nationality: ${player.nationality}\n")
                    append("Position: ${player.position}\n")
                    append("Market Value: ${player.marketValue}")
                }
                tvItemPreview.text = combinedText

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("PLAYER", player)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}