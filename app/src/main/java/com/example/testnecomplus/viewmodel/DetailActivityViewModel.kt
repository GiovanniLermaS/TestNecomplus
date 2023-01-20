package com.example.testnecomplus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testnecomplus.model.Track
import com.example.testnecomplus.repository.detail.IDetailActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailActivityViewModel @Inject constructor(private val detailActivityRepository: IDetailActivityRepository) :
    ViewModel() {

    private val _tracks = MutableLiveData<ArrayList<Track>>()
    val tracks: LiveData<ArrayList<Track>> = _tracks

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getTracks(artistTrackName: String?) {
        detailActivityRepository.getTracks(artistTrackName, {
            _tracks.postValue(it.topTracks.track)
        }, {
            _error.postValue(it)
        })
    }
}