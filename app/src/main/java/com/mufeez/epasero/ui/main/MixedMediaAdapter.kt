package com.mufeez.epasero.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.mufeez.epasero.data.model.FeedItem
import com.mufeez.epasero.R
import me.relex.circleindicator.CircleIndicator3

class MixedMediaAdapter(
    private val context: Context,
    private val mixedItems: List<FeedItem.MixedItem>
) : RecyclerView.Adapter<MixedMediaAdapter.MMixedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MMixedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mixed, parent, false)
        return MMixedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MMixedViewHolder, position: Int) {
        val item = mixedItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = mixedItems.size

    class MMixedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val viewPager: ViewPager2 = itemView.findViewById(R.id.viewPager)
        private val indicator: CircleIndicator3 = itemView.findViewById(R.id.indicator)

        fun bind(item: FeedItem.MixedItem) {
            val mixedMediaPagerAdapter = MixedMediaPagerAdapter(itemView.context, item.mediaItems)
            viewPager.adapter = mixedMediaPagerAdapter
            indicator.setViewPager(viewPager)
        }
    }
}
