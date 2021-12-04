package com.example.kursach.teams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.R

class TeamsAdapter(
    private val teamsList: List<Teams>
    ): RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>(){

//    private lateinit var binding: BindingAdapter

    override fun getItemCount(): Int = teamsList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_team, parent, false)
        return TeamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(teamsList[position])
    }

    class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tvName)

        fun bind(item: Teams){
            tvName.text = item.Team
        }
    }

}


