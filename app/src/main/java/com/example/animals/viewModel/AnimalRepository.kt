package com.example.animals.viewModel

class AnimalRepository private constructor(private val animalDao: FakeAnimalDao) {

    fun addAnimal(animal: Animal) {
        animalDao.addAnimal(animal)
    }

    fun getAnimal() = animalDao.getAnimal()

    companion object {
        @Volatile
        private var instance: AnimalRepository? = null

        fun getInstance(animalDao: FakeAnimalDao) =
            instance ?: synchronized(lock = this) {
                instance ?: AnimalRepository(animalDao).also { instance = it }
            }
    }
}