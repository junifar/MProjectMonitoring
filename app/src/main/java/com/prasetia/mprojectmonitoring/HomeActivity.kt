package com.prasetia.mprojectmonitoring

import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.prasetia.mprojectmonitoring.adapter.ProjectCorrectiveAdapter
import com.prasetia.mprojectmonitoring.config.ExternalUrl.Companion.MOBILE_API_URL
import com.prasetia.mprojectmonitoring.config.Logs
import com.prasetia.mprojectmonitoring.pojo.ProjectCorrective
import com.prasetia.mprojectmonitoring.service.ProjectCorrectiveApiService
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var adapter:ProjectCorrectiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        Logs.trackLog(androidId,"Access HomeActivity")

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        getProjectCorrective()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        projectCorrectiveRecyclerView.layoutManager = linearLayoutManager

    }

    fun getProjectCorrective(){
        val retrofit = Retrofit.Builder()
                .baseUrl(MOBILE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val projectCorrectiveApiService = retrofit.create(ProjectCorrectiveApiService::class.java)
        val result = projectCorrectiveApiService.getResultProjectCorrective()
        result.enqueue(object :Callback<List<ProjectCorrective>>{
            override fun onResponse(call: Call<List<ProjectCorrective>>?, response: Response<List<ProjectCorrective>>?) {
                if (response != null) {
                    adapter = ProjectCorrectiveAdapter(response.body()!!)
                    projectCorrectiveRecyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<ProjectCorrective>>?, t: Throwable?) {
                t?.printStackTrace()
            }

        })
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
