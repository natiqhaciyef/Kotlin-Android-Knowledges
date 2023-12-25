package com.natiqhaciyef.kotlinandroidknowledges.android.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.android.view.recyclerview.model.ItemModel
import com.natiqhaciyef.kotlinandroidknowledges.databinding.RecyclerItemViewBinding

class ItemAdapter(
    private val list: List<ItemModel>,
    private val onLongClickEvent: (Boolean) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var isEnabled = false
    private var itemSelectedList = mutableListOf<Int>()

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.itemTitle)
        val checkBox: CheckBox = view.findViewById(R.id.itemCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_view, parent, false)
        return ItemViewHolder(layout)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.itemTitle.text = item.title

        holder.itemView.setOnLongClickListener {
            selectItem(holder, item, position)
            true
        }

        holder.checkBox.setOnClickListener {
            holder.checkBox.visibility = View.GONE
            itemSelectedList.remove(position)

            if (itemSelectedList.isEmpty()) {
                onLongClickEvent(false)
                isEnabled = false
            }
        }

        holder.itemView.setOnClickListener {
            if (itemSelectedList.contains(position)) {
                itemSelectedList.remove(position)
                holder.checkBox.isChecked = false
                item.isEnabled = false
                holder.checkBox.visibility = View.GONE

                if (itemSelectedList.isEmpty()) {
                    onLongClickEvent(false)
                    isEnabled = false
                }


            } else if (isEnabled) {
                selectItem(holder, item, position)
            }
        }
    }

    private fun selectItem(holder: ItemViewHolder, item: ItemModel, position: Int) {
        isEnabled = true
        itemSelectedList.add(position)
        item.isEnabled = true
        holder.checkBox.isChecked = true
        holder.checkBox.visibility = View.VISIBLE
        onLongClickEvent(true)
    }
}