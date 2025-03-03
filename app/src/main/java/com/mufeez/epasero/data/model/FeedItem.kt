package com.mufeez.epasero.data.model

/*sealed class FeedItem {
    data class PhotoItem(val imageUrl: String) : FeedItem()
    data class VideoItem(val videoUrl: String) : FeedItem()
    data class MixedItem(val imageUrl: String, val videoUrl: String) : FeedItem()
}*/

sealed class FeedItem {
    data class PhotoItem(
        val id: String,
        val imageUrl: String
    ) : FeedItem()

    data class VideoItem(
        val id: String,
        val videoUrl: String
    ) : FeedItem()

    data class MixedItem(
        val id: String,
        val mediaItems: List<MediaItem>
    ) : FeedItem()
}


data class MediaItem(
    val type: MediaType,
    val url: String
)

enum class MediaType {
    IMAGE,
    VIDEO
}