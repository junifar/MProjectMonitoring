package com.prasetia.mprojectmonitoring.service

import com.prasetia.mprojectmonitoring.pojo.SiteResult
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface  SiteApiService{
    @GET("/public/site")
    fun getResultSite(): Call<List<SiteResult>>

    @GET("/public/site")
    fun getResultSiteAsJson(): Call<ResponseBody>
}