package com.mufeez.epasero.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mufeez.epasero.data.model.MediaItem
import com.mufeez.epasero.data.model.MediaType
import com.mufeez.epasero.R


class MixedMediaPagerAdapter(
    private val context: Context,
    private val mediaItems: List<MediaItem>
) : RecyclerView.Adapter<MixedMediaPagerAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_media, parent, false)
        return MediaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val mediaItem = mediaItems[position]
        holder.bind(mediaItem)
    }

    override fun getItemCount(): Int = mediaItems.size

    inner class MediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.photoImageView)
        private val playerView: PlayerView = itemView.findViewById(R.id.videoPlayer)

        fun bind(item: MediaItem) {
            when (item.type) {
                MediaType.IMAGE -> {
                    imageView.visibility = View.VISIBLE
                    playerView.visibility = View.GONE
                    Glide.with(itemView.context)
                        .load(item.url)
                        .into(imageView)
                }
                MediaType.VIDEO -> {
                    playerView.visibility = View.VISIBLE
                    imageView.visibility = View.GONE
                    val player = ExoPlayer.Builder(itemView.context).build()
                    playerView.player = player
                    val mediaItem = androidx.media3.common.MediaItem.Builder().setUri(item.url).build()
                    player.setMediaItem(mediaItem)
                    player.prepare()
                    player.playWhenReady = true
                }
            }
        }
    }
}
