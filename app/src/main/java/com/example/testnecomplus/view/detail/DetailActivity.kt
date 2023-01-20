package com.example.testnecomplus.view.detail

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testnecomplus.databinding.ActivityDetailBinding
import com.example.testnecomplus.model.Artist
import com.example.testnecomplus.utils.ARTIST_NAME
import com.example.testnecomplus.view.detail.adapter.TracksAdapter
import com.example.testnecomplus.view.detail.interfaces.ClickTrack
import com.example.testnecomplus.viewmodel.DetailActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity(), ClickTrack {

    private val detailActivityViewModel by viewModels<DetailActivityViewModel>()

    private var binding: ActivityDetailBinding? = null

    private val progress by lazy { ProgressDialog(this) }

    private val artistTrackName by lazy { intent.getSerializableExtra(ARTIST_NAME) as String }

    override fun onCreate(savedInstanceState: Bundle?) {
        progress.show()
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        detailActivityViewModel.tracks.observe(this) {
            progress.dismiss()
            binding?.rvTracks?.adapter = TracksAdapter(it, this)
        }
        detailActivityViewModel.error.observe(this) {
            progress.dismiss()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        detailActivityViewModel.getTracks(artistTrackName)
    }

    override fun onTrackSelected(artist: Artist) {
        TODO("Not yet implemented")
    }
}