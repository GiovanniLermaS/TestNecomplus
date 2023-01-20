package com.example.testnecomplus.view.detail

import com.example.testnecomplus.repository.detail.DetailActivityRepository
import com.example.testnecomplus.repository.detail.IDetailActivityRepository
import com.example.testnecomplus.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DetailModule {

    @Provides
    fun provideAboutRepository(apiInterface: ApiInterface): IDetailActivityRepository {
        return DetailActivityRepository(apiInterface)
    }
}