package com.example.githubusersviewer.user.list.view.adapter.viewholder.group

import com.example.githubusersviewer.databinding.GithubUserGroupItemBinding
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import com.example.githubusersviewer.user.list.view.adapter.viewmodel.group.GithubUserGroupItemViewModel
import com.example.githubusersviewer.view.base.ItemViewHolder
import com.example.githubusersviewer.view.utils.getLifecycleOwner

class GithubUserGroupViewHolder(
    private val binding: GithubUserGroupItemBinding,
    private val githubUserGroupItemViewModel: GithubUserGroupItemViewModel
) : ItemViewHolder<GithubUserListItem.GithubUserGroup>(binding.root) {

    override fun onBind(item: GithubUserListItem.GithubUserGroup) {
        githubUserGroupItemViewModel.setModel(item)
        binding.lifecycleOwner = itemView.context.getLifecycleOwner()
        binding.executePendingBindings()
    }

}