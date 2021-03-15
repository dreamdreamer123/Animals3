package com.example.animals

import androidx.lifecycle.ViewModel
import com.example.animals.viewModel.Animal
import com.example.animals.viewModel.AnimalRepository

class MainViewModel(private val animalRepository: AnimalRepository) : ViewModel() {

    fun getAnimals() = animalRepository.getAnimal()

    fun addAnimals(animal: Animal) = animalRepository.addAnimal(animal)

}