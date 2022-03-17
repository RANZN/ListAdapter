package com.example.listadapter.app.persentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.listadapter.R
import com.example.listadapter.app.persentation.MainViewModel
import com.example.listadapter.app.persentation.adapter.MainRecyclerViewAdapter
import com.example.listadapter.app.persentation.listners.OnItemClick
import com.example.listadapter.common.Resource
import com.example.listadapter.databinding.FragmentDiscoverBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DiscoverFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentDiscoverBinding
    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private val viewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiscoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()

        viewModel.data.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    mainRecyclerViewAdapter.submitList(result.data?.results)
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, result.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setRecyclerView() {
        mainRecyclerViewAdapter = MainRecyclerViewAdapter(this)

        val concatAdapterConfig = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(false)
            .build()

        val concatAdapter = ConcatAdapter(concatAdapterConfig, mainRecyclerViewAdapter)

        val gridLayoutManager = GridLayoutManager(context, 3)

        gridLayoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                when (mainRecyclerViewAdapter.getItemViewType(position)) {
                    R.layout.featured_item_layout -> 3
                    R.layout.carousel_item_layout -> 3
                    R.layout.shoppable_item_layout -> 3
                    R.layout.nested_item_layout -> 1
                    else -> 3
                }
        }

        binding.mainRecyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = concatAdapter
        }

    }

    override fun onItemClick(id: Int) {
//        val intent = Intent(context, DetailedActivity::class.java)
//        intent.putExtra("id", id)
//        startActivity(intent)
        Toast.makeText(context, "$id", Toast.LENGTH_SHORT).show()
    }
}