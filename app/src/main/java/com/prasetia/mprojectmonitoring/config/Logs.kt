package com.prasetia.mprojectmonitoring.config

import com.prasetia.mprojectmonitoring.service.LogApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by prasetia on 11/24/2017.
 */
class Logs {
    companion object {
        fun trackLog(sid:String ,message:String){

            val params = HashMap<String, String>()
            params.put("devid", sid)
            params.put("message", message)

            val retrofit = Retrofit.Builder()
                    .baseUrl(ExternalUrl.MOBILE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val logApiService = retrofit.create(LogApiService::class.java)
            val result = logApiService.Save(params)
            result.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {

                }

                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    t?.printStackTrace()
                }

            })
        }
    }

}