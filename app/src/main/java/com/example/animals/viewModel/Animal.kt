package com.example.animals.viewModel

data class Animal(
    val name: String,
    val age: String,
    val gender: String,
    val breed: String,
    val favouriteFood: String
) {
    override fun toString(): String {
        return "$name, $gender, $age, $breed, $favouriteFood"
    }
}