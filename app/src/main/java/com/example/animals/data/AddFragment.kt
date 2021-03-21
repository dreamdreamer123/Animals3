package com.example.animals.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import com.example.animals.MainViewModel
import com.example.animals.R
import com.example.animals.viewModel.Animal
import android.widget.ArrayAdapter as ArrayAdapter

class AddFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add, container, false)

        val habitatList = resources.getStringArray(R.array.habitat)
        val spinner = root.findViewById<Spinner>(R.id.spinnerHabitat)

        if (spinner != null) {
            val adapter = activity?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item, habitatList
                )
            }
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        val button = root.findViewById<Button>(R.id.button_add)
        val name = root.findViewById<EditText>(R.id.editName)
        val gender = root.findViewById<EditText>(R.id.editGender)
        val age = root.findViewById<EditText>(R.id.editAge)
        val food = root.findViewById<EditText>(R.id.editFood)
        val breed = root.findViewById<EditText>(R.id.editBreed)
        val mHabitat = spinner.selectedItem
        val movement = root.findViewById<RadioGroup>(R.id.movementRadioGroup)


        if (name.text.toString().isEmpty()) {
            name.requestFocus()
            name.error = "FIELD CANNOT BE EMPTY!"
        }
        if (gender.text.toString().isEmpty()) {
            gender.requestFocus()
            gender.error = "FIELD CANNOT BE EMPTY!"
        }
        if (age.text.toString().isEmpty()) {
            age.requestFocus()
            age.error = "FIELD CANNOT BE EMPTY!"
        }
        if (food.text.toString().isEmpty()) {
            food.requestFocus()
            food.error = "FIELD CANNOT BE EMPTY!"
        }
        if (breed.text.toString().isEmpty()) {
            breed.requestFocus()
            breed.error = "FIELD CANNOT BE EMPTY!"
        }


        button.setOnClickListener {
            val animal = Animal(
                name.text.toString(),
                age.text.toString().toInt(),
                gender.text.toString(),
                breed.text.toString(),
                food.text.toString(),
                mHabitat.toString(),
                root.findViewById<RadioButton>(movement.checkedRadioButtonId).text.toString()
            )

            viewModel.addAnimal(animal)
            name.text.clear()
            gender.text.clear()
            age.text.clear()
            food.text.clear()
            breed.text.clear()
            movement.clearCheck()
        }
        return root
    }
}

