package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignIn.setOnClickListener {
            val progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)

            //Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
            progressBar.progress = 0
            progressBar.max = 100
            progressBar.showContextMenu()
        }
    }
}
