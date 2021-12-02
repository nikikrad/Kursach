package com.example.kursach.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.R

class EventAdapter(
    private val eventList: List<Event>
): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun getItemCount(): Int = eventList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
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