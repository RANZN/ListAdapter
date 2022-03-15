package com.example.listadapter.app.domain.model

import com.google.gson.annotations.SerializedName

data class CompilationsItem(

	@field:SerializedName("aspect_ratio")
	val aspectRatio: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("is_shoppable")
	val isShoppable: Boolean? = null,

	@field:SerializedName("keywords")
	val keywords: Any? = null,

	@field:SerializedName("facebook_posts")
	val facebookPosts: List<Any?>? = null,

	@field:SerializedName("show")
	val show: List<ShowItem?>? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("description")
	val description: Any? = null,

	@field:SerializedName("draft_status")
	val draftStatus: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("thumbnail_url")
	val thumbnailUrl: String? = null,

	@field:SerializedName("thumbnail_alt_text")
	val thumbnailAltText: String? = null,

	@field:SerializedName("video_url")
	val videoUrl: String? = null,

	@field:SerializedName("approved_at")
	val approvedAt: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("canonical_id")
	val canonicalId: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("beauty_url")
	val beautyUrl: String? = null,

	@field:SerializedName("buzz_id")
	val buzzId: Any? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("promotion")
	val promotion: String? = null,

	@field:SerializedName("video_id")
	val videoId: Int? = null
)