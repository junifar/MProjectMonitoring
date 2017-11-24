package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.adapter.rxjava2.Result

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnSignin.setOnClickListener(
                Toast.makeText(applicationContext.f"berhasil",Toast.LENGTH_SHORT).show();
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.signup, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
