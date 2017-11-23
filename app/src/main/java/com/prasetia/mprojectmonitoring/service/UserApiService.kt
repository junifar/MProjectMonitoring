package com.prasetia.mprojectmonitoring.service

import com.prasetia.mprojectmonitoring.pojo.Result
import com.prasetia.mprojectmonitoring.pojo.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by prasetia on 11/21/2017.
 */
interface UserApiService {
    @GET("api")
    fun getResultInfo(): Call<Result>

    @GET("api")
    fun getResultAsJSON(): Call<Result>

    @GET("public/muser")
    fun getUser(): Call<List<User>>
}