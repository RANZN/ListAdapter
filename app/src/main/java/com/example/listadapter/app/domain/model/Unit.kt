package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class Unit(

	@field:SerializedName("system")
	val system: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("display_plural")
	val displayPlural: String? = null,

	@field:SerializedName("display_singular")
	val displaySingular: String? = null,

	@field:SerializedName("abbreviation")
	val abbreviation: String? = null
)