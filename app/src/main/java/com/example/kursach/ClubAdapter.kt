package com.example.kursach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClubAdapter(
    private val clubList: List<com.example.kursach.Club>
): RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {

    override fun getItemCount(): Int = clubList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClubAdapter.ClubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_club, parent, false)
        return ClubViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClubAdapter.ClubViewHolder, position: Int) {
        holder.bind(clubList[position])
    }

    class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        private val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)

        fun bind(item: Club){
            tvName.text = item.Name
            tvNumber.text = item.Number
            tvEmail.text = item.Email
        }
    }
}