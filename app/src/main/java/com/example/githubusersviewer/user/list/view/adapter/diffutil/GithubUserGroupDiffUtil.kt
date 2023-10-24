package com.example.githubusersviewer.user.list.view.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem

class GithubUserGroupDiffUtil(
    private val oldList: List<GithubUserListItem>,
    private val newList: List<GithubUserListItem>
) : DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemIndex: Int, newItemIndex: Int): Boolean {
        val oldItem = oldList[oldItemIndex]
        val newItem = newList[newItemIndex]
        return oldItem.javaClass == newItem.javaClass
    }

    override fun areContentsTheSame(oldItemIndex: Int, newItemIndex: Int): Boolean {
        val oldItem = oldList[oldItemIndex]
        val newItem = newList[newItemIndex]
        return oldItem == newItem
    }


}