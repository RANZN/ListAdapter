package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)