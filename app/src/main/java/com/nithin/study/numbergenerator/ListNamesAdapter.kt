package com.nithin.study.numbergenerator

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.nithin.study.R
import kotlinx.android.synthetic.main.list_names.view.*

class ListNamesAdapter(private val context: Context, var listNames: List<Person>) : BaseAdapter() {
    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = LayoutInflater.from(context).inflate(R.layout.list_names, parent, false)


        view.listNamesTextName.text = listNames[position].name + " " + listNames[position].surname


        return view
    }

    override fun getItem(position: Int): Any {
        return listNames[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listNames.size
    }
}