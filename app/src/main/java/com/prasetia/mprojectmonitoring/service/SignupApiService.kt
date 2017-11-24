package com.prasetia.mprojectmonitoring.service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by prasetia on 11/24/2017.
 */
interface SignupApiService {

    @FormUrlEncoded
    @POST("public/msignup/save")
    fun Save(@FieldMap params:HashMap<String, String>): Call<ResponseBody>
}