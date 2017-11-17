package com.prasetia.mprojectmonitoring

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.prasetia.mprojectmonitoring.service.SiteProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {

    val compositeDisposeable: CompositeDisposable = CompositeDisposable()

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
            val siteRepository = SiteProvider.providerSite()

            compositeDisposeable.add(
                    siteRepository.searchSite()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({
                                SiteResult ->
                                Log.d("Result", "${SiteResult.items[0].id}")
                            },{ error -> error.printStackTrace()})
            )
        }
    }
}
