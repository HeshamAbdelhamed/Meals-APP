package com.example.data.repo

import com.example.data.remote.MealsApi
import com.example.domain.entity.MealModelItems
import com.example.domain.repo.MainScreenRepo
import javax.inject.Inject

class MainRepoImpl @Inject constructor(private val mealsApi: MealsApi) : MainScreenRepo {
    override suspend fun getMealsFromRemote(): MealModelItems {
        return mealsApi.getMeals()
    }
}