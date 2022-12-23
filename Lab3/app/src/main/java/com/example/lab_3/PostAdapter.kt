package com.example.lab_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.databinding.PostLayoutBinding

class PostAdapter: RecyclerView.Adapter<PostAdapter.PostHolder>() {
val postList = ArrayList<Post>()
    class PostHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PostLayoutBinding.bind(item)
        fun bind(post: Post) = with(binding){
            tvPost.text = post.tvTextPost
            tvName.text = post.tvName
            tvDate.text = post.tvDate
            tvReplies.text = post.tvTextReplies
            imView.setImageResource(post.imView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_layout,parent,false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    fun uploadData(list:List<Post>){
        postList.addAll(list)
        notifyDataSetChanged()
    }
}