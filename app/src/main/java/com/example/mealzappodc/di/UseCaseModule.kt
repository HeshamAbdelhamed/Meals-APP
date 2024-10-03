package com.example.mealzappodc.di

import com.example.domain.repo.MainScreenRepo
import com.example.domain.usecase.GetMealsFromRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    //Main
    @Provides
    fun provideGetMealsFromRemoteUseCase(mainRepo: MainScreenRepo): GetMealsFromRemote {
        return GetMealsFromRemote(mainRepo)
    }
}