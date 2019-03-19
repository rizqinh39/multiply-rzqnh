package com.example.assessmentwecan.ui.adapter

import android.view.View
import com.example.assessmentwecan.helper.listener.RecyclerOnClickListener

class BaseViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var onClickListener: RecyclerOnClickListener? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun setOnClickListener(listener: RecyclerOnClickListener) {
        this.onClickListener = listener
    }

    override fun onClick(p0: View?) {
        onClickListener?.onClick(p0!!, adapterPosition)
    }

}