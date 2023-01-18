package com.example.testnecomplus.view.main

import com.example.testnecomplus.repository.main.IMainActivityRepository
import com.example.testnecomplus.repository.main.MainActivityRepository
import com.example.testnecomplus.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideAboutRepository(apiInterface: ApiInterface): IMainActivityRepository {
        return MainActivityRepository(apiInterface)
    }
}