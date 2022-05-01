package com.dev.challenge.challengeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.challenge.challengeapp.api.responses.User
import com.dev.challenge.challengeapp.databinding.AdapterUserBinding


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var users = mutableListOf<User>()

    fun setUserList(users: List<User>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterUserBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
        holder.binding.title.text = user.title
        holder.binding.id.text = user.id.toString()
        holder.binding.userId.text = user.userId.toString()
        holder.binding.body.text = user.body
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

class MainViewHolder(val binding: AdapterUserBinding) : RecyclerView.ViewHolder(binding.root) {

}
