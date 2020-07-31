package com.example.tikicloneapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.tikicloneapp.Model.User

class UserAdapter (private var mContexxt: Context,
                   private var mUser: List<User>,
                   private var  isFragment: Boolean=false ):RecyclerView.Adapter<UserAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    class ViewHolder (@NonNull itemView: View): RecyclerView.ViewHolder(itemView){

    }
}