package com.example.listadapter.app.persentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.listadapter.R
import com.example.listadapter.app.persentation.fragments.DiscoverFragment
import com.example.listadapter.app.persentation.fragments.RecipesFragment
import com.example.listadapter.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //adding first fragment by default
        supportFragmentManager.beginTransaction().replace(R.id.fragContainer, DiscoverFragment()).commit()

        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.discover -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragContainer, DiscoverFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.recipes -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragContainer, RecipesFragment()).commit()
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }

    }
}