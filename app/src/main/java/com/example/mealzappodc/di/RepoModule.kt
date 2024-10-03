package com.example.mealzappodc.di

import com.example.data.remote.MealsApi
import com.example.data.repo.MainRepoImpl
import com.example.domain.repo.MainScreenRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideMainScreenRepo(
        api: MealsApi
    ): MainScreenRepo {
        return MainRepoImpl(api)
    }
}