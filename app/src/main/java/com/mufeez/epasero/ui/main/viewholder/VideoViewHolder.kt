package com.mufeez.epasero.ui.main.viewholder

import android.net.Uri
import android.view.View
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView
import com.mufeez.epasero.data.model.FeedItem
import com.mufeez.epasero.R


class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val playerView: PlayerView = itemView.findViewById(R.id.videoPlayer)

    fun bind(item: FeedItem.VideoItem) {
        val player = ExoPlayer.Builder(itemView.context).build()
        playerView.player = player

        val mediaItem = MediaItem.fromUri(Uri.parse(item.videoUrl))
        player.setMediaItem(mediaItem)

        player.prepare()
        player.play()
    }
}
