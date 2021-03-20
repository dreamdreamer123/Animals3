package com.example.animals.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.animals.MainViewModel
import com.example.animals.R
import com.example.animals.viewModel.Animal

class AnimalsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_animals, container, false)
        val linearLayout = root.findViewById<LinearLayout>(R.id.contact_container)
        viewModel.animalList.observe(viewLifecycleOwner, Observer {
            linearLayout.removeAllViews()
            for (animal in it) {
                val row = inflater.inflate(R.layout.animal_row, linearLayout, false)
                val textView = row.findViewById<TextView>(R.id.animal_text)
                textView.text = animal.getDetails()
                linearLayout.addView(row)
            }
        })
        return root
    }

    fun Animal.getDetails() = "$name, $gender, $age, $breed, $favouriteFood"
}