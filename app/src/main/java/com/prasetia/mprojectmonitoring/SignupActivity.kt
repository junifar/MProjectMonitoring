package com.prasetia.mprojectmonitoring

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import com.prasetia.mprojectmonitoring.config.Logs
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity(){

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        Logs.trackLog( androidId, "Access SignupActivity")

        btnSignup.setOnClickListener({
            validateName()
            validateEmail()
            validatePassword()
            validateConfirmPassword()
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

    fun checkPassword(value:String, value2:String): Boolean{
        return value.equals(value2, ignoreCase = true)
    }

}
