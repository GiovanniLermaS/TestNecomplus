package com.example.testnecomplus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testnecomplus.model.Artist
import com.example.testnecomplus.repository.main.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    private val _topArtists = MutableLiveData<ArrayList<Artist>>()
    val data: LiveData<ArrayList<Artist>> = _topArtists

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getTopArtists() {
        mainActivityRepository.getTopArtists({
            _topArtists.postValue(it.artists)
        }, {
            _error.postValue(it)
        })
    }
}