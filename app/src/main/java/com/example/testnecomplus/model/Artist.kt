package com.example.testnecomplus.model

import com.google.gson.annotations.SerializedName

open class Artist {
    @SerializedName("name")
    val name: String? = null

    @SerializedName("image")
    val image = ArrayList<Image>()
}