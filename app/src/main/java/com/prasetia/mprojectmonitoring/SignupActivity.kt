package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import android.widget.Toast
import android.widget.EditText
import java.util.jar.Attributes


class SignupActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)





        btnSignin.setOnClickListener({

            if (txtName.text.toString()) {
                txtName.setError("Username diperlukan!");
                return@setOnClickListener
            }
        })
            /*if(!checkLength(txtEmail.text.toString())) {
                displayError(txtEmail, txtLayoutEmail, message = "Email Diperlukan")
                return@setOnClickListener
            }
            if(!checkLength(txtPassword.text.toString())) {
                displayError(txtPassword, txtLayoutPassword, message = "password Diperlukan")
                return@setOnClickListener
            }


        })

    }
        fun displayError(v: TextInputEditText, v2: TextInputLayout, message: String) {
            v.setError(message)
            v2.isErrorEnabled = true
        }

        fun checkLength(value1: String): Boolean {
            return value1.isNotEmpty()
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.signup, menu)
            return super.onCreateOptionsMenu(menu)
        }
    }

//
//protected fun onCreate(savedInstanceState: Bundle) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//    ButterKnife.bind(this)
//
//    validator = Validator(this)
//    validator.setValidationListener(this)
//}
