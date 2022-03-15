package com.example.listadapter.app.persentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.listadapter.R
import com.example.listadapter.app.persentation.MainViewModel
import com.example.listadapter.databinding.FragmentReceipesBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RecipesFragment : Fragment() {

    private lateinit var binding: FragmentReceipesBinding
    private val viewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_receipes, container, false)
        return binding.root
    }


}