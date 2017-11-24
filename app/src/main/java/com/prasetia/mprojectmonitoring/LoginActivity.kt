package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.prasetia.mprojectmonitoring.config.ExternalUrl.Companion.MOBILE_API_URL
import com.prasetia.mprojectmonitoring.config.Logs.Companion.trackLog
import com.prasetia.mprojectmonitoring.pojo.User
import com.prasetia.mprojectmonitoring.service.UserApiService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

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
                var value = ""
                if (response != null) {
                    for (user in response.body()!!){
                        value += " " + user.id.toString()
                    }
                }
                txtUserName.setText(value)
                progressBar.visibility = View.GONE
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        trackLog(androidId, "Access LoginActivity")

        progressBar.visibility = View.GONE

        btnSignIn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            getUser()
        }
    }
}
