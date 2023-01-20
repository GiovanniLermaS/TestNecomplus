package com.example.testnecomplus.view.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testnecomplus.R
import com.example.testnecomplus.databinding.ViewArtistsBinding
import com.example.testnecomplus.model.Track
import com.example.testnecomplus.view.detail.interfaces.ClickTrack

class TracksAdapter(
    private val artists: ArrayList<Track>,
    private val clickTrack: ClickTrack
) : RecyclerView.Adapter<TracksAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewArtistsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_artists, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists[position]
        Glide.with(holder.itemView)
            .load(artist.image)
            .into(holder.binding.ivImage)
        holder.binding.tvName.text = artist.name
        holder.itemView.setOnClickListener { clickTrack.onTrackSelected(artist) }
    }

    override fun getItemCount() = artists.size
}