package com.prasetia.mprojectmonitoring

//import android.support.v4.app.Fragment
import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prasetia.mprojectmonitoring.adapter.ChoiceMenuAdapter
import com.prasetia.mprojectmonitoring.pojo.Menu
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private fun fillMenu(): List<Menu> {
        return listOf(
            Menu(1, "Profile"),
            Menu(2, "EPM")
        )
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val adapter = ChoiceMenuAdapter(this.fillMenu())
        val gridLayoutManager = GridLayoutManager(context, 4)

        choice_menu.layoutManager = gridLayoutManager
        choice_menu.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
