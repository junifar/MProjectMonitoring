package com.prasetia.mprojectmonitoring.pojo

import com.google.gson.annotations.SerializedName

data class Site(

	@field:SerializedName("write_date")
	val writeDate: String? = null,

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("write_uid")
	val writeUid: Int? = null,

	@field:SerializedName("value2")
	val value2: String? = null,

	@field:SerializedName("department_id")
	val departmentId: Int? = null,

	@field:SerializedName("value1")
	val value1: Any? = null,

	@field:SerializedName("kpi")
	val kpi: String? = null,

	@field:SerializedName("create_uid")
	val createUid: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("periode")
	val periode: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("create_date")
	val createDate: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)