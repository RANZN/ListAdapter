package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class UserRatings(

	@field:SerializedName("count_positive")
	val countPositive: Int? = null,

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("count_negative")
	val countNegative: Int? = null
)