package com.example.kursach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
    private val eventList: List<com.example.kursach.Event>
): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun getItemCount(): Int = eventList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventAdapter.EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_event, parent, false)
        return EventAdapter.EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventAdapter.EventViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvKindOfSport: TextView = itemView.findViewById(R.id.tvKindOfSport)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvTime: TextView = itemView.findViewById(R.id.tvTime)

        fun bind(item: Event){
            tvKindOfSport.text = item.KindOfSport
            tvDate.text = item.Date
            tvTime.text = item.Time
        }
    }

}