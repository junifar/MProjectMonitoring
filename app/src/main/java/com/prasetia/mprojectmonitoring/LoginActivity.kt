package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.prasetia.mprojectmonitoring.config.ExternalUrl.Companion.SITE_API_URL
import com.prasetia.mprojectmonitoring.pojo.Result
import com.prasetia.mprojectmonitoring.pojo.SiteResult
import com.prasetia.mprojectmonitoring.service.SiteApiService
import com.prasetia.mprojectmonitoring.service.UserApiService
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private val BASE_API_URL: String = "https://randomuser.me/"

    private fun getSiteInfo(){
        val retrofit = Retrofit.Builder()
                .baseUrl(SITE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val siteApiService = retrofit.create(SiteApiService::class.java)

        val result = siteApiService.getResultSiteAsJson()
        result.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                t?.printStackTrace()
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                if (response != null) {
                    //txtUserName.setText(response.body()!!.string())
                    val gson = Gson()
                    val result = gson.fromJson(response.body()?.string(), SiteResult::class.java)
                    txtUserName.setText(result.site[0].id.toString())
                }
                progressBar.visibility = View.GONE
            }
        })
//        result.enqueue(object:Callback<List<SiteResult>>{
//            override fun onFailure(call: Call<List<SiteResult>>?, t: Throwable?) {
//                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
//                t?.printStackTrace()
//                progressBar.visibility = View.GONE
//            }
//
//            override fun onResponse(call: Call<List<SiteResult>>?, response: Response<List<SiteResult>>?) {
//                if (response != null) {
//                    for(SiteResult in response.body()!!){
//                        txtUserName.setText(SiteResult.site?.id.toString())
//                    }
//
//                }
//                progressBar.visibility = View.GONE
//            }
//
//        })
    }

    private fun initializeRetrofit(){
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val userApiService = retrofit.create(UserApiService::class.java)

//        TODO::Contoh Balikan Object
        val result = userApiService.getResultInfo()
        result.enqueue( object:Callback<Result>{
                override fun onFailure(call: Call<Result>?, t: Throwable?) {
                    t?.printStackTrace()
                    progressBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                    if (response != null) {
                        Toast.makeText(applicationContext, response.body()?.info?.seed, Toast.LENGTH_SHORT).show()
                    }
                    progressBar.visibility = View.GONE
                }

            }
        )

//        TODO::Contoh Balikan JSON
//        val result = userApiService.getResultAsJSON()
//        result.enqueue(object :Callback<Result>{
//            override fun onFailure(call: Call<Result>?, t: Throwable?) {
//                t?.printStackTrace()
//            }
//
//            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
//                if (response != null) {
//                    Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressBar.visibility = View.GONE

        btnSignIn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
//            initializeRetrofit()
            getSiteInfo()
        }
    }
}
