package com.example.kursach.teams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.R

class TeamsAdapter(
    private val teamList: List<Team>
    ): RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>(){

    override fun getItemCount(): Int = teamList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_team, parent, false)
        return TeamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(teamList[position])
    }

    class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvSportClubs: TextView = itemView.findViewById(R.id.tvSportClubs)

        fun bind(item: Team){
            tvName.text = item.teamName
            tvSportClubs.text = item.idSportClubs.toString()
        }
    }

}


