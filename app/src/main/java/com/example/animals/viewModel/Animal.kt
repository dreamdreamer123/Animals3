package com.example.animals.viewModel

import java.io.Serializable

class Animal constructor(
    val name: String,
    val age: Int,
    val gender: String,
    val breed: String,
    val favouriteFood: String,
    val habitat: String,
    val movement: String
) : Serializable