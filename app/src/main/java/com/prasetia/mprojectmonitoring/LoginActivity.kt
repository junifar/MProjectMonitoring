package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.prasetia.mprojectmonitoring.pojo.Result
import com.prasetia.mprojectmonitoring.service.UserApiService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private val BASE_API_URL: String = "https://randomuser.me/"

    private fun initializeRetrofit(){
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val userApiService = retrofit.create(UserApiService::class.java)

//        TODO::Contoh Balikan Object
//        val result = userApiService.getResultInfo()
//        result.enqueue( object:Callback<Result>{
//                override fun onFailure(call: Call<Result>?, t: Throwable?) {
//                    t?.printStackTrace()
//                }
//
//                override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
//                    if (response != null) {
//                        Toast.makeText(applicationContext, response.body()?.info?.seed, Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//            }
//        )

//        TODO::Contoh Balikan JSON
        val result = userApiService.getResultAsJSON()
        result.enqueue(object :Callback<Result>{
            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                if (response != null) {
                    Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    fun test(result:String?){
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializeRetrofit()

        btnSignIn.setOnClickListener {
            initializeRetrofit()
        }
    }
}
