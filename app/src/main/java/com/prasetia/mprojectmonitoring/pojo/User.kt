package com.prasetia.mprojectmonitoring.pojo

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("password")
	val password: Any? = null,

	@field:SerializedName("created")
	val created: Any? = null,

	@field:SerializedName("last_name")
	val lastName: Any? = null,

	@field:SerializedName("modified")
	val modified: Any? = null,

	@field:SerializedName("user_created")
	val userCreated: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("locked")
	val locked: Int? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: Any? = null,

	@field:SerializedName("user_modified")
	val userModified: Any? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("sid")
	val sid: Any? = null
)