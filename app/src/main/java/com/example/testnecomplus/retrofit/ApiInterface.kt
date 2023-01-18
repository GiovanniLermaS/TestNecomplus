package com.example.testnecomplus.retrofit

import com.example.testnecomplus.model.TopArtists
import com.example.testnecomplus.utils.API_KEY
import com.example.testnecomplus.utils.GET_ARTISTS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(GET_ARTISTS)
    fun getTopArtists(@Query(API_KEY) apiKey: String): Call<TopArtists>
}