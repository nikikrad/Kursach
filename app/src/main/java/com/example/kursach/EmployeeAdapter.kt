package com.example.kursach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(
    private val employeeList: List<com.example.kursach.Employee>
): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun getItemCount(): Int = employeeList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeAdapter.EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_employee, parent, false)
        return EmployeeAdapter.EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeAdapter.EmployeeViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvSurname: TextView = itemView.findViewById(R.id.tvSurname)
        private val tvLastname: TextView = itemView.findViewById(R.id.tvLastname)
        private val tvPosition: TextView = itemView.findViewById(R.id.tvPosition)

        fun bind(item: Employee){
            tvName.text = item.Name
            tvSurname.text = item.Surname
            tvLastname.text = item.Lastname
            tvPosition.text = item.Position
        }
    }


}