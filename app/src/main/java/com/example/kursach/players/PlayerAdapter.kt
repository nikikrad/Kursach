package com.example.kursach.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.R

class PlayerAdapter(
        private val playerList: List<Player>
): RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    override fun getItemCount(): Int = playerList.size

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvSurname: TextView = itemView.findViewById(R.id.tvSurname)
        private val tvLastname: TextView = itemView.findViewById(R.id.tvLastname)
        private val tvDisch: TextView = itemView.findViewById(R.id.tvDisch)
        private val tvKindOfSport: TextView = itemView.findViewById(R.id.tvKindOfSport)
        private val tvRoll: TextView = itemView.findViewById(R.id.tvRoll)


        fun bind(item: Player){
            tvName.text = item.Name
            tvSurname.text = item.Surname
            tvLastname.text = item.Lastname
            tvDisch.text = item.DischName
            tvKindOfSport.text = item.SportName
            tvRoll.text = item.RollName
        }
    }

}