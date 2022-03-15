package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class MeasurementsItem(

	@field:SerializedName("unit")
	val unit: Unit? = null,

	@field:SerializedName("quantity")
	val quantity: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)