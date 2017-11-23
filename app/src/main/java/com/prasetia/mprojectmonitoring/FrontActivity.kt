package com.prasetia.mprojectmonitoring

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_front.*

class FrontActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        btnLogin.setOnClickListener({
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        })

        btnHome.setOnClickListener({
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        })

        btnSignup.setOnClickListener({
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        })
    }
}
