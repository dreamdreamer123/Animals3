package com.example.animals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animals.viewModel.AnimalRepository

class AnimalsViewModelFactory(private val animalRepository: AnimalRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(animalRepository) as T
    }
}