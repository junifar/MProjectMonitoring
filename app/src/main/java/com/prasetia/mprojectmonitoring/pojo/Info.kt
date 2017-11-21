package com.prasetia.mprojectmonitoring.pojo

import com.google.gson.annotations.SerializedName

data class Info(

	@field:SerializedName("seed")
	val seed: String? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: Int? = null,

	@field:SerializedName("version")
	val version: String? = null
)