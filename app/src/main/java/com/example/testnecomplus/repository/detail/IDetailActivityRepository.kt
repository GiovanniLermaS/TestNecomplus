package com.example.testnecomplus.repository.detail

import com.example.testnecomplus.model.Data

interface IDetailActivityRepository {
    fun getTracks(
        artistTrackName: String?,
        response: (Data) -> Unit,
        error: (String?) -> Unit
    )
}