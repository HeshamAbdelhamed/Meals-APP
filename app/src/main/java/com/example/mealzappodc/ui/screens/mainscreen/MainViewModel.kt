package com.example.mealzappodc.ui.screens.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MealModelItems
import com.example.domain.usecase.GetMealsFromRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(private val getMealsFromRemote: GetMealsFromRemote) :
    ViewModel() {

    private val _meals = MutableStateFlow(MealModelItems(emptyList()))
    val meals = _meals.asStateFlow()

    init {
        getMeals()
    }

    private fun getMeals() {
        viewModelScope.launch {
            try {
                val data = getMealsFromRemote()
                _meals.value = data
                Log.d(TAG, "getMeals: ${Thread.currentThread().name}")
                Log.d(TAG, "getMeals: ${data.categories[0].strCategory}")
            } catch (e: Exception) {
                if (e is HttpException) {
                    Log.d(TAG, "HttpException getMeals: ${e.message}")
                } else {
                    Log.d(TAG, "Exception getMeals: ${e.message}")
                }
            }
        }
    }
}