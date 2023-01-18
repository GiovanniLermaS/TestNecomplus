package com.example.testnecomplus.view.main

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testnecomplus.databinding.ActivityMainBinding
import com.example.testnecomplus.model.Artist
import com.example.testnecomplus.view.main.adapter.ArtistsAdapter
import com.example.testnecomplus.view.main.interfaces.ClickArtist
import com.example.testnecomplus.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickArtist {

    private val homeActivityViewModel by viewModels<MainActivityViewModel>()

    private var binding: ActivityMainBinding? = null

    private val progress by lazy { ProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        progress.show()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        homeActivityViewModel.data.observe(this) {
            progress.dismiss()
            binding?.rvArtists?.adapter = ArtistsAdapter(it, this)
        }
        homeActivityViewModel.error.observe(this) {
            progress.dismiss()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        homeActivityViewModel.getTopArtists()
    }

    override fun onArtistSelected(artist: Artist) {

    }
}