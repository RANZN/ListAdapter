package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class SectionsItem(

	@field:SerializedName("components")
	val components: List<ComponentsItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("position")
	val position: Int? = null
)