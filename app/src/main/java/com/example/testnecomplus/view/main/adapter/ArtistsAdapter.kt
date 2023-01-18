package com.example.testnecomplus.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnecomplus.R
import com.example.testnecomplus.databinding.ViewArtistsBinding
import com.example.testnecomplus.model.TopArtists
import com.example.testnecomplus.view.main.interfaces.ClickArtist

class ArtistsAdapter(private val data: TopArtists, private val clickArtist: ClickArtist) :
    RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewArtistsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_artists, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount() = data.artists.size
}