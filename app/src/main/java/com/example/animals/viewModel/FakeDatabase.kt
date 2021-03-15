package com.example.animals.viewModel

class FakeDatabase private constructor() {

    var animalDao = FakeAnimalDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(lock = this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}