package com.example.testnecomplus.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

const val BASE_URL = "https://ws.audioscrobbler.com/2.0/"
const val GET_ARTISTS =
    "?method=geo.gettopartists&country=colombia&limit=10&format=json&api_key="
const val GET_TRACKS =
    "?method=artist.gettoptracks&limit=5&format=json&api_key="
const val ARTIST_NAME = "artist"

fun hasNetwork(context: Context): Boolean? {
    var isConnected: Boolean? = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}