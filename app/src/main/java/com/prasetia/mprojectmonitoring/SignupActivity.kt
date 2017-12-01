package com.prasetia.mprojectmonitoring

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.prasetia.mprojectmonitoring.config.Encrypt
import com.prasetia.mprojectmonitoring.config.ExternalUrl.Companion.MOBILE_API_URL
import com.prasetia.mprojectmonitoring.config.Logs
import com.prasetia.mprojectmonitoring.service.SignupApiService
import kotlinx.android.synthetic.main.activity_signup.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SignupActivity : AppCompatActivity(){

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val preference = getSharedPreferences("com.prasetia.MProjectMonitoring", Context.MODE_PRIVATE)
        preference.edit().putString(Encrypt.encrypt("Sample"), Encrypt.encrypt("contoh")).apply()

//        Toast.makeText(applicationContext, UUID.randomUUID().toString(), Toast.LENGTH_LONG).show()
//        Toast.makeText(applicationContext, Encrypt.decrypt(preference.getString("Sample","")), Toast.LENGTH_LONG).show()


        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        Logs.trackLog( androidId, "Access SignupActivity")

        btnSignup.setOnClickListener({
            validateName()
            if (txtUsername.text.isEmpty()) return@setOnClickListener
            validateEmail()
            if (txtEmail.text.isEmpty()) return@setOnClickListener
            validatePassword()
            if (txtPassword.text.isEmpty()) return@setOnClickListener
            validateConfirmPassword()
            if (txtConfirmPassword.text.isEmpty()) return@setOnClickListener

            if (!checkPassword(txtPassword.text.toString(), txtConfirmPassword.text.toString())){
                Toast.makeText(applicationContext, "Password Tidak Sama", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            content_layout.visibility = View.GONE
            loading_layout.visibility = View.VISIBLE

            saveRecord(txtUsername.text.toString(), txtEmail.text.toString(), txtPassword.text.toString())
        })

        txtUsername.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if(!hasFocus) {
                validateName()
            }
        }

        txtEmail.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if(!hasFocus) {
                validateEmail()
            }
        }

        txtPassword.onFocusChangeListener = View.OnFocusChangeListener{ _, hasFocus ->
            if(!hasFocus) {
                validatePassword()
            }
        }

        txtConfirmPassword.onFocusChangeListener = View.OnFocusChangeListener{ _, hasFocus ->
            if(!hasFocus) {
                validateConfirmPassword()
            }
        }
    }

    private fun saveRecord(username:String, email:String, password:String){
        val params = HashMap<String, String>()
        params.put("username", username)
        params.put("email", email)
        params.put("password", password)

        val retrofit = Retrofit.Builder()
                .baseUrl(MOBILE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val result = retrofit.create(SignupApiService::class.java).Save(params)
        result.enqueue(object:Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                content_layout.visibility = View.VISIBLE
                loading_layout.visibility = View.GONE
                Toast.makeText(applicationContext, "Data can't process, please try again later", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                loading_layout.visibility = View.GONE
                finish_layout.visibility = View.VISIBLE
//                btn_login.setOnClickListener({
//                    navigateUpTo(parentActivityIntent)
//                    finish()
//                })
            }

        })

    }

    private fun validateConfirmPassword() {
        if (!checkLength(txtConfirmPassword.text)) {
            showError(txtConfirmPass, "Password Can't Blank", true)
        } else {
            showError(txtConfirmPass, null, false)
        }
    }

    private fun validatePassword() {
        if (!checkLength(txtPassword.text)) {
            showError(txtLayoutPassword, "Password Can't Blank", true)
        } else {
            showError(txtLayoutPassword, null, false)
        }
    }

    private fun validateEmail() {
        if (!checkLength(txtEmail.text)) {
            showError(txtLayoutEmail, "Email Can't Blank", true)
        } else {
            showError(txtLayoutEmail, null, false)
        }
    }

    private fun validateName(){
        if (!checkLength(txtUsername.text)){
            showError(txtLayoutName, "Name Can't Blank", true)
        } else{
            showError(txtLayoutName, null,false)
        }
    }

    private fun showError(textInputLayout: TextInputLayout, errorMessage:String?, isErrorEnabled:Boolean){
        textInputLayout.error = errorMessage
        textInputLayout.isErrorEnabled = isErrorEnabled
    }

    fun checkLength(value: Editable): Boolean {
        return value.isNotEmpty()
    }

    fun checkPassword(value: String, value2: String): Boolean{
        return value == value2
    }

}
