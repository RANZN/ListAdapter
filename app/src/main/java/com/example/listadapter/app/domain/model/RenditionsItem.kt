package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class RenditionsItem(

	@field:SerializedName("container")
	val container: String? = null,

	@field:SerializedName("poster_url")
	val posterUrl: String? = null,

	@field:SerializedName("file_size")
	val fileSize: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("duration")
	val duration: Int? = null,

	@field:SerializedName("bit_rate")
	val bitRate: Int? = null,

	@field:SerializedName("content_type")
	val contentType: String? = null,

	@field:SerializedName("aspect")
	val aspect: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("minimum_bit_rate")
	val minimumBitRate: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("maximum_bit_rate")
	val maximumBitRate: Any? = null,

	@field:SerializedName("height")
	val height: Int? = null
)