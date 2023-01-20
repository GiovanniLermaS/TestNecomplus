package com.example.testnecomplus.repository.detail

import com.example.testnecomplus.model.Data
import com.example.testnecomplus.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class DetailActivityRepository(private val apiInterface: ApiInterface) : IDetailActivityRepository {

    override fun getTracks(
        artistTrackName: String?,
        response: (Data) -> Unit,
        error: (String?) -> Unit
    ) {
        val call = apiInterface.getTracks(artistTrackName)
        call.enqueue(object : Callback<Data> {
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                response.body()?.let { response(it) }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                t.message?.let { error(it) }
            }

        })
    }
}