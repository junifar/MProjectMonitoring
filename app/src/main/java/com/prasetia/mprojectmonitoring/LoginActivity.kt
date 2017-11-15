package com.prasetia.mprojectmonitoring

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {

//    private val progressDialog = ProgressDialog(this)

    inner class getLoginAuth : AsyncTask<Void, Void, String>(){
        override fun doInBackground(vararg p0: Void?): String {
            val url = URL("https://api.prasetia.co.id/public/site")
            val conn = url.openConnection() as HttpURLConnection

            conn.readTimeout = 5000
            conn.connectTimeout = 5000
            conn.requestMethod = "POST"

            val responseCode = conn.responseCode
            if (responseCode != HttpURLConnection.HTTP_OK){
                return ""
            }

            return  "Success"
        }

        override fun onPostExecute(result: String?) {

            super.onPostExecute(result)
            test(result)
        }
    }

    fun test(result:String?){
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignIn.setOnClickListener {

//            val layout = RelativeLayout(this)
//            val progressDialog = ProgressBar(this,
//                    null, android.R.attr.progressBarStyleSmall)
//            progressDialog.isIndeterminate = true
//            progressDialog.visibility= View.VISIBLE
//
//            val params = RelativeLayout.LayoutParams(100,100)
//            params.addRule(RelativeLayout.CENTER_IN_PARENT)
//            layout.addView(progressDialog, params)
//
//            setContentView(layout)

//            progressDialog.setCancelable(false)
//            progressDialog.show()
//            getLoginAuth().execute()
        }
    }
}
