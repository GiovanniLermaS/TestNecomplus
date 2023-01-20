package com.example.testnecomplus.model

import com.google.gson.annotations.SerializedName

class TopTracks {
    @SerializedName("track")
    val track = ArrayList<Track>()
}