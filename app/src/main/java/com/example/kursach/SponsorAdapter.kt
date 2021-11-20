package com.example.kursach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SponsorAdapter(
    private val sponsorList: List<com.example.kursach.Sponsor>
    ): RecyclerView.Adapter<SponsorAdapter.SponsorViewHolder>() {

    override fun getItemCount(): Int = sponsorList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SponsorAdapter.SponsorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_sponsor, parent, false)
        return SponsorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SponsorAdapter.SponsorViewHolder, position: Int) {
        holder.bind(sponsorList[position])
    }

    class SponsorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        private val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)

        fun bind(item: Sponsor){
            tvName.text = item.Name
            tvNumber.text = item.Number
            tvEmail.text = item.Email
        }
    }
}