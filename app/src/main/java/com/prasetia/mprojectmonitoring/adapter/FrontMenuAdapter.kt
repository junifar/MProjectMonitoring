package com.prasetia.mprojectmonitoring.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prasetia.mprojectmonitoring.R

/**
 * Created by prasetia on 11/23/2017.
 */
class FrontMenuAdapter: RecyclerView.Adapter<FrontMenuAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FrontMenuAdapter.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.content_home, parent, false)
        return ViewHolder(view)
    }

   class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
       init {

       }


   }
}