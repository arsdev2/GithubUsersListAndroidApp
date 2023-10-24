package com.example.githubusersviewer.user.list.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusersviewer.user.list.view.adapter.diffutil.GithubUserGroupDiffUtil
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import com.example.githubusersviewer.user.list.view.adapter.viewholder.group.GithubUserGroupViewHolderFactory
import com.example.githubusersviewer.user.list.view.adapter.viewholder.user.GithubUserViewHolderFactory
import com.example.githubusersviewer.view.base.ItemViewHolder

class GithubUserListAdapter(
    private val githubUserGroupViewHolderFactory: GithubUserGroupViewHolderFactory,
    private val githubUserViewHolderFactory: GithubUserViewHolderFactory
) : RecyclerView.Adapter<ItemViewHolder<GithubUserListItem>>(){

    companion object {
        const val GITHUB_GROUP_TYPE = 1;
        const val GITHUB_USER_TYPE = 2;
    }

    private var data = emptyList<GithubUserListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<GithubUserListItem> {
        return when(viewType) {
            GITHUB_GROUP_TYPE -> githubUserGroupViewHolderFactory.create(parent)
            GITHUB_USER_TYPE -> githubUserViewHolderFactory.create(parent)
            else -> throw RuntimeException("Invalid view type: $viewType")
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when(data[position]) {
            is GithubUserListItem.GithubUserGroup -> GITHUB_GROUP_TYPE
            is GithubUserListItem.GithubUser -> GITHUB_USER_TYPE
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder<GithubUserListItem>, position: Int) {
        holder.onBind(data[position])
    }

    fun updateData(newList: List<GithubUserListItem>) {
        val result = DiffUtil.calculateDiff(GithubUserGroupDiffUtil(data, newList))
        data = newList
        result.dispatchUpdatesTo(this)
    }

}