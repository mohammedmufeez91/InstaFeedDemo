package com.mufeez.epasero.data.repository


import com.mufeez.epasero.data.model.FeedItem
import com.mufeez.epasero.data.model.MediaItem
import com.mufeez.epasero.data.model.MediaType
import javax.inject.Inject

class FeedRepository @Inject constructor() {

    fun getFeedItems(): List<FeedItem> {
        return listOf(
            FeedItem.VideoItem(
                "1",
                "https://www.w3schools.com/html/mov_bbb.mp4"
            ),
            FeedItem.PhotoItem(
                "2",
                "https://www.w3schools.com/w3images/lights.jpg"
            ),
            FeedItem.MixedItem(
                "3",
                listOf(
                    MediaItem(MediaType.IMAGE, "https://www.w3schools.com/w3images/nature.jpg"),
                    MediaItem(MediaType.VIDEO, "https://www.w3schools.com/html/movie.mp4")
                )
            ),
            FeedItem.VideoItem(
                "4",
                "https://www.w3schools.com/html/mov_bbb.mp4" // Sample video 3
            ),
            FeedItem.PhotoItem(
                "5",
                "https://www.w3schools.com/w3images/lights.jpg" // Sample image 3
            )
        )
    }

}

