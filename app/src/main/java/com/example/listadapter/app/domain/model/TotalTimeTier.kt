package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class TotalTimeTier(

	@field:SerializedName("tier")
	val tier: String? = null,

	@field:SerializedName("display_tier")
	val displayTier: String? = null
)