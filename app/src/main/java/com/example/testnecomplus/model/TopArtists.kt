package com.example.testnecomplus.model

import com.google.gson.annotations.SerializedName

class TopArtists {

    @SerializedName("artist")
    val artists = ArrayList<Artist>()
}