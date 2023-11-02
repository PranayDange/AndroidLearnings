package com.example.viewsandwidets.signup

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.viewsandwidets.R
/*

class CountryAdapter(context: Context, countryList: List<Country>) : BaseAdapter() {
    private val countries = countryList
    override fun getCount(): Int {
        return countries.size
    }

    override fun getItem(position: Int): Any {
       return countries[position]
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {
        val inflate = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false)
        return inflate
    }
}*/
class CountryAdapter(private val context: Context, private val countryList: List<Country>) : BaseAdapter() {
    override fun getCount(): Int {
        return countryList.size
    }

    override fun getItem(position: Int): Any {
        return countryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            // If convertView is null, inflate the layout
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.country_item, null)
        } else {
            view = convertView
        }

        // Now, populate the view with data from the Country object
        val country = getItem(position) as Country

        val countryNameTextView = view.findViewById<TextView>(R.id.countryName)
        val countryAboutTextView = view.findViewById<TextView>(R.id.countryAbout)

        countryNameTextView.text = country.name
        countryAboutTextView.text = country.about

        return view
    }
}
