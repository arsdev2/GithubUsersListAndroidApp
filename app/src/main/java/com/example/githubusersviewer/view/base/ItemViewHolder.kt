package com.example.githubusersviewer.view.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder<out T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: @UnsafeVariance T)

}