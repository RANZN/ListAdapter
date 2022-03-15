package com.example.listadapter.app.persentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.listadapter.R
import com.example.listadapter.app.domain.model.ResultsItem
import com.example.listadapter.databinding.CarouselItemLayoutBinding
import com.example.listadapter.databinding.FeaturedItemLayoutBinding
import com.example.listadapter.databinding.ShoppableItemLayoutBinding
import com.example.listadapter.app.persentation.listners.OnItemClick
import com.example.listadapter.databinding.NestedItemLayoutBinding
import java.lang.IllegalArgumentException

class MainRecyclerViewAdapter(private val onItemClick: OnItemClick) : ListAdapter<ResultsItem, ViewHolder>(diffUtilCallBack) {

    companion object {
        val diffUtilCallBack = object : DiffUtil.ItemCallback<ResultsItem>() {
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.minItems == newItem.minItems
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            "featured" -> R.layout.featured_item_layout
            "shoppable_carousel" -> R.layout.shoppable_item_layout
            "carousel" -> R.layout.carousel_item_layout
            "item" -> R.layout.nested_item_layout
            else -> "Invalid View Type".toInt()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.featured_item_layout -> {
                val binding = FeaturedItemLayoutBinding.inflate(layoutInflater, parent, false)
                ViewHolder.FeaturedViewHolder(binding)
            }
            R.layout.shoppable_item_layout -> {
                val binding = ShoppableItemLayoutBinding.inflate(layoutInflater, parent, false)
                ViewHolder.ShoppableCarouselViewHolder(binding)
            }
            R.layout.carousel_item_layout -> {
                val binding = CarouselItemLayoutBinding.inflate(layoutInflater, parent, false)
                ViewHolder.CarouselViewHolder(binding)
            }
            R.layout.nested_item_layout -> {
                val binding = NestedItemLayoutBinding.inflate(layoutInflater, parent, false)
                ViewHolder.ItemViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.FeaturedViewHolder -> holder.bindData(getItem(position), onItemClick)
            is ViewHolder.ShoppableCarouselViewHolder -> holder.bindData(getItem(position), onItemClick)
            is ViewHolder.CarouselViewHolder -> holder.bindData(getItem(position), onItemClick)
            is ViewHolder.ItemViewHolder -> holder.bindData(getItem(position), onItemClick)
        }
    }
}

sealed class ViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class CarouselViewHolder(private val binding: CarouselItemLayoutBinding) : ViewHolder(binding) {
        fun bindData(data: ResultsItem, onItemClick: OnItemClick) {
            binding.tvResultName.text = data.name
            binding.nestedRecyclerView.apply {
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = NestedRecyclerViewAdapter(data.items!!, onItemClick)
            }

        }
    }

    class FeaturedViewHolder(private val binding: FeaturedItemLayoutBinding) : ViewHolder(binding) {
        fun bindData(resultsItem: ResultsItem, onItemClick: OnItemClick) {
            binding.apply {
                tvItemName.text = resultsItem.item?.name
                Glide.with(featuredImage).load(resultsItem.item?.thumbnailUrl).into(featuredImage)
                layout.setOnClickListener {
                    onItemClick.onItemClick(resultsItem.item?.id!!)
                }
            }
        }
    }

    class ShoppableCarouselViewHolder(private val binding: ShoppableItemLayoutBinding) : ViewHolder(binding) {
        fun bindData(data: ResultsItem, onItemClick: OnItemClick) {
            binding.apply {
                binding.tvResultName.text = data.name
                binding.nestedRecyclerView.apply {
                    layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = NestedRecyclerViewAdapter(data.items!!, onItemClick)
                }
            }
        }
    }

    class ItemViewHolder(private val binding: NestedItemLayoutBinding) : ViewHolder(binding) {
        fun bindData(result: ResultsItem, onItemClick: OnItemClick) {
            binding.apply {
                tvItemName.text = result.item?.name
                Glide.with(ivItemImage).load(result.item?.thumbnailUrl).placeholder(R.drawable.ic_broken).into(ivItemImage)
                layout.setOnClickListener {
                    onItemClick.onItemClick(result.item?.id!!)
                }
            }
        }
    }

}