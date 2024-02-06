package com.example.mylistview.fragments.list.lists

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.RemoteMediator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.ImageRequest
import com.example.mylistview.data.User
import com.example.mylistview.databinding.CustomRowBinding



class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userlist = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CustomRowBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userlist[position]
       // holder.binding.textView.text = currentItem.id.toString()
        holder.binding.firstnameTxt.text = currentItem.firstName
        holder.binding.ageTxt.text = currentItem.age.toString()
    }

    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root)


    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<User>) {
        this.userlist = user
        notifyDataSetChanged()
    }

    private class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }
}