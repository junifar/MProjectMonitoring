package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.prasetia.mprojectmonitoring.config.ExternalUrl.Companion.MOBILE_API_URL
import com.prasetia.mprojectmonitoring.config.ExternalUrl.Companion.SITE_API_URL
import com.prasetia.mprojectmonitoring.pojo.Result
import com.prasetia.mprojectmonitoring.pojo.Site
import com.prasetia.mprojectmonitoring.pojo.User
import com.prasetia.mprojectmonitoring.service.SiteApiService
import com.prasetia.mprojectmonitoring.service.UserApiService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private val BASE_API_URL: String = "https://randomuser.me/"

    private fun getSite(){
        val retrofit = Retrofit.Builder()
                .baseUrl(SITE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val siteApiService = retrofit.create(SiteApiService::class.java)
        val result = siteApiService.getResultSite()
        result.enqueue(object :Callback<List<Site>>{
            override fun onResponse(call: Call<List<Site>>?, response: Response<List<Site>>?) {
                if (response != null) {
                    var value:String = ""
                    for (site in response.body()!!){
//                        Toast.makeText(applicationContext, site.id!!.toString(), Toast.LENGTH_LONG).show()
                        value += " " + site.id.toString()
                    }
                    txtUserName.setText(value)
                }
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<Site>>?, t: Throwable?) {
                t?.printStackTrace()
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun getUser(){
        val retrofit = Retrofit.Builder()
                .baseUrl(MOBILE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val userApiService = retrofit.create(UserApiService::class.java)
        val result = userApiService.getUser()
        result.enqueue(object:Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                t?.printStackTrace()
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
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
            getSite()
        }
    }
}
