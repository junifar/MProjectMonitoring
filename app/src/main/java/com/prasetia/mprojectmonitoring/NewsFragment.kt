package com.prasetia.mprojectmonitoring

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_news, container, false)
    }

    companion object {
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }
}