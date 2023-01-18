package com.example.testnecomplus.model

import com.google.gson.annotations.SerializedName

class Artist {
    @SerializedName("name")
    val name: String? = null

    @SerializedName("image")
    val image = ArrayList<Image>()
}