package com.prasetia.mprojectmonitoring

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import com.prasetia.mprojectmonitoring.config.Logs

class SignupActivity : AppCompatActivity() {

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        Logs.trackLog( androidId, "Access SignupActivity")
    }

}
