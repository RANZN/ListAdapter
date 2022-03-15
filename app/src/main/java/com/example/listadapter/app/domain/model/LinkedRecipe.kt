package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class LinkedRecipe(

	@field:SerializedName("approved_at")
	val approvedAt: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("thumbnail_url")
	val thumbnailUrl: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)