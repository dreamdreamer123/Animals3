package com.example.animals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animals.viewModel.Animal

class MainViewModel() : ViewModel() {

    val animalList = MutableLiveData<ArrayList<Animal>>()

    init {
        animalList.value = arrayListOf(
            Animal("Dona", 7, "Female", "Husky", "checken")
        )
    }

    fun addAnimal(animal: Animal) {
        animalList.value?.add(animal)
    }
}