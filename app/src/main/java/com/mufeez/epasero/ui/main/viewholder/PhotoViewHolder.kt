package com.mufeez.epasero.ui.main.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mufeez.epasero.data.model.FeedItem
import com.mufeez.epasero.R

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.photoImageView)

    fun bind(item: FeedItem.PhotoItem) {
        Glide.with(itemView.context)
            .load(item.imageUrl)
            .into(imageView)
    }
}
