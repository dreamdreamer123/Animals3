package com.example.animals.util

import com.example.animals.viewModel.AnimalRepository
import com.example.animals.AnimalsViewModelFactory
import com.example.animals.viewModel.FakeDatabase

object InjectorUtils {

    fun provideAnimalsViewModel(): AnimalsViewModelFactory {
        val animalRepository = AnimalRepository.getInstance(FakeDatabase.getInstance().animalDao)
        return AnimalsViewModelFactory(animalRepository)
    }
}