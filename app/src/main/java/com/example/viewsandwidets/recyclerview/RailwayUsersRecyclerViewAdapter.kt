package com.example.viewsandwidets.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewsandwidets.R

class RailwayUsersRecyclerViewAdapter(private val railwayUsersList: List<RailwayUsers>) :
    RecyclerView.Adapter<RailwayList>() {

    private val railwayUsers = railwayUsersList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RailwayList {
        /*val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.railway_user_list_recycler_view, parent, false)
        return RailwayList(inflater)*/
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.railway_user_list_recycler_view, parent, false)
        return RailwayList(view)
    }

    override fun getItemCount(): Int {
        return railwayUsers.size
    }

    override fun onBindViewHolder(holder: RailwayList, position: Int) {
        val railwayUsersModel = railwayUsers[position]
        holder.name.text = railwayUsersModel.name
        holder.email.text = railwayUsersModel.email
        holder.about.text = railwayUsersModel.about
    }

}

class RailwayList(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.name_view)
    val email: TextView = itemView.findViewById(R.id.email_view)
    val about: TextView = itemView.findViewById(R.id.about_view)
}
