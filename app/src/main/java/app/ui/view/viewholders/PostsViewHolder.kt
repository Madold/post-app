package app.ui.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import app.data.model.PostModel
import com.markusw.postsapp.R
import com.markusw.postsapp.databinding.ItemPostBinding

class PostsViewHolder(view: View): ViewHolder(view) {

    private val binding = ItemPostBinding.bind(view)

    fun render(post: PostModel) {
        binding.postTitleTxt.text = post.title
        binding.postDescriptionTxt.text = post.description

        println(post.imageURL)

        Glide.with(binding.postImageView.context)
            .asBitmap()
            .load(post.imageURL)
            .error(R.drawable.ic_launcher_background)
            .into(binding.postImageView)
    }


}