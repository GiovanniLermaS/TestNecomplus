package com.example.testnecomplus.repository.main

import com.example.testnecomplus.model.Data

interface IMainActivityRepository {
    fun getTopArtists(
        response: (Data) -> Unit,
        error: (String?) -> Unit
    )
}