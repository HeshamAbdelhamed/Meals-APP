package com.example.data.remote

import com.example.domain.entity.MealModelItems
import retrofit2.http.GET

interface MealsApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getMeals(): MealModelItems
    //https://www.themealdb.com/

}