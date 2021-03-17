package com.example.animals.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.animals.MainViewModel
import com.example.animals.R
import com.example.animals.viewModel.Animal

class AddFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add, container, false)
        val button = root.findViewById<Button>(R.id.button_add)
        val name = root.findViewById<EditText>(R.id.editName)
        val gender = root.findViewById<EditText>(R.id.editGender)
        val age = root.findViewById<EditText>(R.id.editAge)
        val food = root.findViewById<EditText>(R.id.editFood)
        val breed = root.findViewById<EditText>(R.id.editBreed)
        button.setOnClickListener {
            val animal = Animal(
               name.text.toString(), age.text.toString().toInt(),
                gender.text.toString(), breed.text.toString(), food.text.toString()
            )
            viewModel.addAnimal(animal)
            name.text.clear()
            gender.text.clear()
            age.text.clear()
            food.text.clear()
            breed.text.clear()
        }
        return root
    }
}
