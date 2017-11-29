package com.prasetia.mprojectmonitoring.pojo

import com.google.gson.annotations.SerializedName

data class Menu (
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null
)