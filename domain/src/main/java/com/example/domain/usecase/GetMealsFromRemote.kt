package com.example.domain.usecase

import com.example.domain.repo.MainScreenRepo

class GetMealsFromRemote(private val mainScreenRepo: MainScreenRepo) {
    suspend operator fun invoke() = mainScreenRepo.getMealsFromRemote()
}