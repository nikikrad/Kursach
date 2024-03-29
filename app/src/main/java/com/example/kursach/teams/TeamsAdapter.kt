package com.example.kursach.teams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.R
import com.example.kursach.databinding.FragmentTeamBinding

class TeamsAdapter(
    private val teamList: List<Team>,
    private val clickListener: (Team) -> Unit
    ): RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>(){

    override fun getItemCount(): Int = teamList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): TeamsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_team, parent, false)
        return TeamsViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(teamList[position])

    }

    class TeamsViewHolder(
        itemView: View,
        private val clickListener: (Team) -> Unit
    ) : RecyclerView.ViewHolder(itemView){

        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvSportClubs: TextView = itemView.findViewById(R.id.tvSportClubs)

        fun bind(item: Team){
            tvName.text = item.teamName
            tvSportClubs.text = item.address
            itemView.setOnClickListener{
                clickListener(item)
            }
        }

    }

}


