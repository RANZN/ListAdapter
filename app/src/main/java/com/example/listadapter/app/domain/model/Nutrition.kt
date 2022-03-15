package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class Nutrition(

	@field:SerializedName("carbohydrates")
	val carbohydrates: Int? = null,

	@field:SerializedName("fiber")
	val fiber: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("protein")
	val protein: Int? = null,

	@field:SerializedName("fat")
	val fat: Int? = null,

	@field:SerializedName("calories")
	val calories: Int? = null,

	@field:SerializedName("sugar")
	val sugar: Int? = null
)