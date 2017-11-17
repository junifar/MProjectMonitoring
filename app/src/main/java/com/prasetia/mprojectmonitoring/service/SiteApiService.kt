package com.prasetia.mprojectmonitoring.service

import com.prasetia.mprojectmonitoring.pojo.SiteResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by prasetia on 11/17/2017.
 */
interface SiteApiService
{
    @GET("/")
    fun getResultSite(): Observable<SiteResult>

    companion object Factory{
        fun create(): SiteApiService{
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.prasetia.co.id/public/site/")
                    .build()
            return retrofit.create(SiteApiService::class.java)
        }
    }
}