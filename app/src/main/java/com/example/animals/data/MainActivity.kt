package com.example.animals.data

import MyAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.animals.util.InjectorUtils
import com.example.animals.MainViewModel
import com.example.animals.R
import com.example.animals.viewModel.Animal
import com.google.android.material.tabs.TabLayout
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.view_pager)
        initializeUi()

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount)

        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun initializeUi() {

        val factory = InjectorUtils.provideAnimalsViewModel()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(MainViewModel::class.java)

        viewModel.getAnimals().observe(this, { animals ->
            val stringBuilder = StringBuilder()
            animals.forEach { animal ->
                stringBuilder.append("$animal\n\n")
            }
            findViewById<TextView>(R.id.animals_text).text = stringBuilder.toString()
        })
        val name = findViewById<EditText>(R.id.name)
        val gender = findViewById<EditText>(R.id.gender)
        val age = findViewById<EditText>(R.id.age)
        val breed = findViewById<EditText>(R.id.breed)
        val food = findViewById<EditText>(R.id.food)


        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            val animal = Animal(
                name.text.toString(),
                age.text.toString(),
                gender.text.toString(),
                breed.text.toString(),
                food.text.toString()
            )
            viewModel.addAnimals(animal)
            name.setText("")
            age.setText("")
            gender.setText("")
            breed.setText("")
            food.setText("")

        }

    }
}