package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class InstructionsItem(

	@field:SerializedName("start_time")
	val startTime: Int? = null,

	@field:SerializedName("appliance")
	val appliance: Any? = null,

	@field:SerializedName("end_time")
	val endTime: Int? = null,

	@field:SerializedName("temperature")
	val temperature: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("display_text")
	val displayText: String? = null
)