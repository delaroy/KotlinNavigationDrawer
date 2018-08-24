package com.delaroystudios.kotlinnavigationdrawer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by delaroy on 8/22/18.
 */
class PlanetAdapter(
        private val dataset: Array<String>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<PlanetAdapter.ViewHolder>() {

    /**
     * Interface for receiving click events from cells.
     */
    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }

    /**
     * Custom [ViewHolder] for our planet views.
     */
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.drawer_list_item, parent, false)
                    .findViewById(android.R.id.text1))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            textView.text = dataset[position]
            textView.setOnClickListener { view -> listener.onClick(view, position) }
        }
    }

    override fun getItemCount() = dataset.size
}