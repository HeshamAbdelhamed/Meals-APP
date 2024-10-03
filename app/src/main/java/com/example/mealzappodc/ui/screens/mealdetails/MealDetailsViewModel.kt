package com.example.mealzappodc.ui.screens.mealdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.entity.Category
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _category = MutableStateFlow(
        Category(
            idCategory = "",
            strCategory = "",
            strCategoryThumb = "",
            strCategoryDescription = ""
        )
    )
    val category = _category.asStateFlow()

    private val argsCurrent: String? = savedStateHandle["category"]

    init {
        argsCurrent?.let {
            val decodedArgs = java.net.URLDecoder.decode(it, "UTF-8")

            val gson = Gson()
            val categoryData = gson.fromJson(decodedArgs, Category::class.java)
            _category.value = categoryData
        }

    }
}