package com.bharathkalyans.roomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bharathkalyans.roomdatabase.R
import com.bharathkalyans.roomdatabase.data.User
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var userList = emptyList<User>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.firstName
        holder.itemView.lastName_txt.text = currentItem.lastName
        holder.itemView.age_text.text = currentItem.age.toString()


    }

    override fun getItemCount(): Int {
        return userList.size
    }


    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}