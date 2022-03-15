package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class ComponentsItem(

	@field:SerializedName("raw_text")
	val rawText: String? = null,

	@field:SerializedName("extra_comment")
	val extraComment: String? = null,

	@field:SerializedName("ingredient")
	val ingredient: Ingredient? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("measurements")
	val measurements: List<MeasurementsItem?>? = null,

	@field:SerializedName("linked_recipe")
	val linkedRecipe: LinkedRecipe? = null
)