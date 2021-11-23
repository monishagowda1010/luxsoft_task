package com.dev.challenge.challengeapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.challenge.challengeapp.api.responses.GetPostsResponseItem
import com.dev.challenge.challengeapp.databinding.PostItemBinding

class PostAdapter :
    androidx.recyclerview.widget.ListAdapter<GetPostsResponseItem, PostAdapter.ViewHolder>(
        PostDiffCallBack()
    ) {

    class ViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: GetPostsResponseItem) {
            binding.tvTitle.text = post.title
            binding.tvDescription.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class PostDiffCallBack : DiffUtil.ItemCallback<GetPostsResponseItem>() {
    override fun areItemsTheSame(
        oldItem: GetPostsResponseItem,
        newItem: GetPostsResponseItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GetPostsResponseItem,
        newItem: GetPostsResponseItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

}