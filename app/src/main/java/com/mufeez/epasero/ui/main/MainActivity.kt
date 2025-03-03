package com.mufeez.epasero.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mufeez.epasero.viewmodel.FeedViewModel
import com.mufeez.epasero.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var feedAdapter: FeedAdapter
    private val viewModel: FeedViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setCustomView(R.layout.custom_actionbar)
            setDisplayShowCustomEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val titleTextView = findViewById<TextView>(R.id.action_bar_title)
        val customFont = ResourcesCompat.getFont(this, R.font.moondance)
        titleTextView?.typeface = customFont

        recyclerView = findViewById(R.id.feedRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        feedAdapter = FeedAdapter(emptyList())
        recyclerView.adapter = feedAdapter

        viewModel.feedItems.observe(this) { items ->
            feedAdapter.updateItems(items)
        }

        viewModel.loadFeed()
    }
}

