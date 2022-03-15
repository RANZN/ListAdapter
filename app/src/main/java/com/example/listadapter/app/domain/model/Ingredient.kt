package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class Ingredient(

	@field:SerializedName("updated_at")
	val updatedAt: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("display_plural")
	val displayPlural: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("display_singular")
	val displaySingular: String? = null
)