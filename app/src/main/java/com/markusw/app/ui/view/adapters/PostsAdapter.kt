package com.markusw.app.ui.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.markusw.app.data.model.PostModel
import com.markusw.app.ui.view.viewholders.PostsViewHolder
import com.markusw.postsapp.R

class PostsAdapter: RecyclerView.Adapter<PostsViewHolder>() {

    private var posts = listOf<PostModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PostsViewHolder(layoutInflater.inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.render(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setPosts(post: List<PostModel>) {
        this.posts = post
        notifyDataSetChanged()
    }

}