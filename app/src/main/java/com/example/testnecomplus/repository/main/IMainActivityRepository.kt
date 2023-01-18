package com.example.testnecomplus.repository.main

import com.example.testnecomplus.model.TopArtists

interface IMainActivityRepository {
    fun getTopArtists(
        response: (TopArtists) -> Unit,
        error: (String?) -> Unit
    )
}