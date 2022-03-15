package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("item")
	val item: Item? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("min_items")
	val minItems: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)