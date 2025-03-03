package com.mufeez.epasero.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mufeez.epasero.data.model.FeedItem
import com.mufeez.epasero.ui.main.viewholder.PhotoViewHolder
import com.mufeez.epasero.R
import com.mufeez.epasero.ui.main.viewholder.VideoViewHolder

class FeedAdapter(
    private var items: List<FeedItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_PHOTO = 0
        private const val TYPE_VIDEO = 1
        private const val TYPE_MIXED = 2
    }

    fun updateItems(newItems: List<FeedItem>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is FeedItem.PhotoItem -> TYPE_PHOTO
            is FeedItem.VideoItem -> TYPE_VIDEO
            is FeedItem.MixedItem -> TYPE_MIXED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_PHOTO -> {
                val view = inflater.inflate(R.layout.item_photo, parent, false)
                PhotoViewHolder(view)
            }
            TYPE_VIDEO -> {
                val view = inflater.inflate(R.layout.item_video, parent, false)
                VideoViewHolder(view)
            }
            TYPE_MIXED -> {
                val view = inflater.inflate(R.layout.item_mixed, parent, false)
                MixedMediaAdapter.MMixedViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is FeedItem.PhotoItem -> (holder as PhotoViewHolder).bind(item)
            is FeedItem.VideoItem -> (holder as VideoViewHolder).bind(item)
            is FeedItem.MixedItem -> (holder as MixedMediaAdapter.MMixedViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size
}


