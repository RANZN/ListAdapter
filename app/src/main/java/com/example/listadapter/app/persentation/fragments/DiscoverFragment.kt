package com.example.listadapter.app.persentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapter.app.domain.model.ResultsItem
import com.example.listadapter.app.persentation.MainViewModel
import com.example.listadapter.app.persentation.adapter.MainRecyclerViewAdapter
import com.example.listadapter.common.Resource
import com.example.listadapter.databinding.FragmentDiscoverBinding
import com.example.listadapter.app.persentation.listners.OnItemClick
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DiscoverFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentDiscoverBinding
    private lateinit var layoutAdapter: MainRecyclerViewAdapter
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
                    layoutAdapter.submitList(result.data?.results)
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
        layoutAdapter = MainRecyclerViewAdapter(this)
        binding.mainRecyclerView.apply {
            adapter = layoutAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    override fun onItemClick(id: Int) {
//        val intent = Intent(context, DetailedActivity::class.java)
//        intent.putExtra("id", id)
//        startActivity(intent)
    }
}