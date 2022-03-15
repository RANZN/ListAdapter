package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class Show(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)