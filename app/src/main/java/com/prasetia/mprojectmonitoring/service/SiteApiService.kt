package com.prasetia.mprojectmonitoring.service

import com.prasetia.mprojectmonitoring.pojo.Site
import retrofit2.Call
import retrofit2.http.GET

interface  SiteApiService{
    @GET("/public/site")
    fun getResultSite(): Call<List<Site>>
}