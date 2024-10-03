package com.example.domain.repo

import com.example.domain.entity.MealModelItems

interface MainScreenRepo {
    suspend fun getMealsFromRemote(): MealModelItems
}