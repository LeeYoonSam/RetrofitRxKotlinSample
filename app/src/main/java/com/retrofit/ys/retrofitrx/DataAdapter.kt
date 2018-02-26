package com.retrofit.ys.retrofitrx

import android.graphics.Color.parseColor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_list.view.*

/**
 * Created by ys on 2018. 2. 26..
 */
class DataAdapter(private val dataList: ArrayList<Android>, private val listener: Listener): RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(android: Android)
    }

    private val colors: Array<String> = arrayOf("#EF5350", "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5")

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(dataList[position], listener, colors, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.row_list, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(android: Android, listener: Listener, colors: Array<String>, position: Int) {
            itemView.tvName.text = android.name
            itemView.tvVersion.text = android.version
            itemView.tvApiLevel.text = android.apiLevel
            itemView.setBackgroundColor(parseColor(colors[position % 6]))

            itemView.setOnClickListener{ listener.onItemClick(android) }
        }
    }
}