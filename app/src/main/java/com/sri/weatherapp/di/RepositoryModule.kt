package com.sri.weatherapp.di

import com.sri.weatherapp.data.ApiService
import com.sri.weatherapp.data.repository.WeatherRepository_Imp
import com.sri.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModel {

    @Binds
    @Singleton
    abstract fun provideRepositoryModule(weatherimpl: WeatherRepository_Imp): WeatherRepository
}
