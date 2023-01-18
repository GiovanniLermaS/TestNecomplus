package com.example.testnecomplus.retrofit

import com.example.testnecomplus.BuildConfig
import com.example.testnecomplus.model.Data
import com.example.testnecomplus.utils.GET_ARTISTS
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(GET_ARTISTS + BuildConfig.API_KEY)
    fun getTopArtists(): Call<Data>
}