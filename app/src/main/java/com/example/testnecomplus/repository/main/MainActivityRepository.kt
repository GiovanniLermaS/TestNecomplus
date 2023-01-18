package com.example.testnecomplus.repository.main

import com.example.testnecomplus.BuildConfig
import com.example.testnecomplus.model.TopArtists
import com.example.testnecomplus.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {

    override fun getTopArtists(response: (TopArtists) -> Unit, error: (String?) -> Unit) {
        val call = apiInterface.getTopArtists(BuildConfig.API_KEY)
        call.enqueue(object : Callback<TopArtists> {
            override fun onResponse(
                call: Call<TopArtists>,
                response: Response<TopArtists>
            ) {
                response.body()?.let { response(it) }
            }

            override fun onFailure(call: Call<TopArtists>, t: Throwable) {
                t.message?.let { error(it) }
            }

        })
    }
}