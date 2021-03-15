package com.example.animals.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeAnimalDao {
    private val animalList = mutableListOf<Animal>()
    private val animals = MutableLiveData<List<Animal>>()

    init {
        animals.value = animalList
    }

    fun addAnimal(animal: Animal) {
        animalList.add(animal)
        animals.value = animalList
    }

    fun getAnimal() = animals as LiveData<List<Animal>>
}