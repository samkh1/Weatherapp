package com.sri.weatherapp.di

import com.sri.weatherapp.data.ApiService
import com.sri.weatherapp.data.repository.WeatherRepository_Imp
import com.sri.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepositoryModule(api: ApiService): WeatherRepository {
        return (WeatherRepository_Imp(api))
    }
}
