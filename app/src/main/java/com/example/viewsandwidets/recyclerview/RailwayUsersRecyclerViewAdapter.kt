package com.example.viewsandwidets.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewsandwidets.R

class RailwayUsersRecyclerViewAdapter(
    context: Context,
    railwayUsersList: List<RailwayUsers>,
    removeButtonClickListenerCallBack: RemoveButtonListenerInterface? = null,
    checkBoxListenerCallback: CheckBoxCheckListener? = null
) :
    RecyclerView.Adapter<RailwayUsersRecyclerViewAdapter.RailwayList>() {

    constructor(context: Context, railwayUsersList: List<RailwayUsers>) : this(
        context,
        railwayUsersList,
        null
    )

    /*   constructor(
           context: Context,
           railwayUsersList: List<RailwayUsers>,
           checkBoxListener: CheckBoxCheckListener
       ) : this(context, railwayUsersList, checkBoxListener, null)*/


    private val railwayUsers = railwayUsersList
    private val removeButtonListener = removeButtonClickListenerCallBack
    private val checkBoxListener = checkBoxListenerCallback

    /*   constructor(context: Context, railwayUsersList: List<RailwayUsers>) : this(context, railwayUsersList) {
           this.context = context,
           this.railwayUsersList = railwayUsersList,
       }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RailwayList {
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

        /*//if we want to handle click in adapter
        holder.btnRemove.setOnClickListener {
            //val context =
            Toast.makeText(it.context, "Remove Btn clicked $position", Toast.LENGTH_SHORT).show()
            railwayUsers.removeAt(position)
            notifyDataSetChanged()
        }*/
        holder.btnRemove.setOnClickListener {
            val position = holder.adapterPosition
            removeButtonListener?.removeButtonClicked(holder.itemView, position)
        }
        holder.checkBoxBtn.setOnCheckedChangeListener { _, b ->
            val position = holder.adapterPosition
            checkBoxListener?.itemChecked(holder.itemView, b, position)
        }

    }


    class RailwayList(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_view)
        val email: TextView = itemView.findViewById(R.id.email_view)
        val about: TextView = itemView.findViewById(R.id.about_view)
        val btnRemove: Button = itemView.findViewById(R.id.btnRemoveItem)
        val checkBoxBtn: CheckBox = itemView.findViewById(R.id.checkBox)

        //if we want to handle click in adapter
        // val btnRemove: TextView = itemView.findViewById(R.id.btnRemoveItem)
    }

}


