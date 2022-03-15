package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class AnalyticsMetadata(

	@field:SerializedName("data_source")
	val dataSource: String? = null
)