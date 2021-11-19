package com.example.kursach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamsAdapter (
    private val teamsList: List<com.example.kursach.Teams>
    ): RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>(){

    override fun getItemCount(): Int = teamsList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamsAdapter.TeamsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_team, parent, false)
        return TeamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsAdapter.TeamsViewHolder, position: Int) {
        holder.bind(teamsList[position])
    }

    class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tvName)

        fun bind(item: Teams){
            tvName.text = item.Team
        }
    }

}


