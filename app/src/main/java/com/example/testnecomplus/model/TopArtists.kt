package com.example.testnecomplus.model

import com.google.gson.annotations.SerializedName

class TopArtists {
    @SerializedName("topartists")
    val artists = ArrayList<Artist>()
}