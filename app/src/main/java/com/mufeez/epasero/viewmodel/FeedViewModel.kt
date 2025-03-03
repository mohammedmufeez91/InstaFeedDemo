package com.mufeez.epasero.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mufeez.epasero.data.model.FeedItem
import com.mufeez.epasero.data.repository.FeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val repository: FeedRepository) : ViewModel() {

    private val _feedItems = MutableLiveData<List<FeedItem>>()
    val feedItems: LiveData<List<FeedItem>> get() = _feedItems

    fun loadFeed() {
        _feedItems.value = repository.getFeedItems()
    }
}