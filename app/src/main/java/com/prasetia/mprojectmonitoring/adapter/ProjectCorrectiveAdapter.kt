package com.prasetia.mprojectmonitoring.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.prasetia.mprojectmonitoring.R
import com.prasetia.mprojectmonitoring.config.inflate
import com.prasetia.mprojectmonitoring.pojo.ProjectCorrective
import kotlinx.android.synthetic.main.item_project_corrective.view.*

/**
 * Created by prasetia on 11/24/2017.
 */
class ProjectCorrectiveAdapter(private val items: List<ProjectCorrective>): RecyclerView.Adapter<ProjectCorrectiveAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ProjectCorrectiveAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProjectCorrectiveAdapter.ViewHolder {
        val inflatedView = parent?.inflate(R.layout.item_project_corrective, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(v: View?) : RecyclerView.ViewHolder(v) {
        private var view: View? = v
        fun bindItem(item: ProjectCorrective){
            view?.textViewName!!.text = item.iD.toString()
        }
    }
}