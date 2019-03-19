package com.example.assessmentwecan.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentwecan.R
import com.example.assessmentwecan.helper.MenuModel
import com.example.assessmentwecan.helper.listener.RecyclerOnClickListener
import kotlinx.android.synthetic.main.item_menu.view.*

class HomeMenuAdapter (mContext: Context, listMenu: MutableList<MenuModel>) : RecyclerView.Adapter<BaseViewHolder>() {

    private var context: Context? = null
    private var list: MutableList<MenuModel>? = null
    private var listener: RecyclerOnClickListener? = null

    init {
        context = mContext
        list = listMenu
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)
        val viewHolder = BaseViewHolder(view)
        viewHolder.setOnClickListener(setOnClickListener())
        return viewHolder
    }

    fun setOnClickListener(listener: RecyclerOnClickListener) {
        this.listener = listener
    }

    private fun setOnClickListener(): RecyclerOnClickListener = object : RecyclerOnClickListener {
        override fun onClick(view: View, position: Int) {
            listener?.onClick(view, position)
        }
    }

    override fun getItemCount(): Int = if (list != null) list!!.size else 0

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = list?.get(position)
        if (item != null) {
            holder.itemView.tv_menu_title.text = item.title
            holder.itemView.iv_item_home.setImageDrawable(item.imageItem)
        }

    }
}