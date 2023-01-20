package com.example.testnecomplus.retrofit

import com.example.testnecomplus.BuildConfig
import com.example.testnecomplus.model.Data
import com.example.testnecomplus.utils.GET_ARTISTS
import com.example.testnecomplus.utils.GET_TRACKS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(GET_ARTISTS + BuildConfig.API_KEY)
    fun getTopArtists(): Call<Data>

    @GET(GET_TRACKS + BuildConfig.API_KEY)
    fun getTracks(@Query("artist") artist: String?): Call<Data>
}