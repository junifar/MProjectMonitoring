package com.prasetia.mprojectmonitoring.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.prasetia.mprojectmonitoring.R
import com.prasetia.mprojectmonitoring.config.inflate
import com.prasetia.mprojectmonitoring.pojo.Menu
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_choice_menu.view.*

class ChoiceMenuAdapter(private val items: List<Menu>): RecyclerView.Adapter<ChoiceMenuAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ChoiceMenuAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceMenuAdapter.ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_choice_menu, false)
        return ViewHolder(inflatedView)
//        return inflatedView?.let{ViewHolder(it)}
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private lateinit var item: com.prasetia.mprojectmonitoring.pojo.Menu

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Toast.makeText(itemView.context, item.id.toString(), Toast.LENGTH_SHORT).show()
        }

        fun bindItem(item: Menu){
            this.item = item
            view.let {
                it.textViewName.text = item.name.toString()
                Picasso.with(it.context)
                        .load(com.prasetia.mprojectmonitoring.R.drawable.logo_prasetia_alone)
//                        .load("http://images4.fanpop.com/image/photos/23200000/Yoyo-and-Cici-yoyo-and-cici-emoticons-23256563-200-200.jpg")
                        .into(it.image_view)
            }
        }
    }
}