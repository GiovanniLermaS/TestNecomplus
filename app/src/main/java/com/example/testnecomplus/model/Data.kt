package com.example.testnecomplus.model

import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("topartists")
    val topArtists = TopArtists()

    @SerializedName("toptracks")
    val topTracks = TopTracks()
}