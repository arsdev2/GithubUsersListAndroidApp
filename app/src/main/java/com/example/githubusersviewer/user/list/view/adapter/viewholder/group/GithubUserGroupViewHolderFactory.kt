package com.example.githubusersviewer.user.list.view.adapter.viewholder.group

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.githubusersviewer.databinding.GithubUserGroupItemBinding
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import com.example.githubusersviewer.user.list.view.adapter.viewmodel.group.GithubUserGroupItemViewModelFactory
import com.example.githubusersviewer.view.base.ItemViewHolder

class GithubUserGroupViewHolderFactory(
    private val layoutInflater: LayoutInflater,
    private val githubUserGroupItemViewModelFactory: GithubUserGroupItemViewModelFactory
) {

    fun create(container: ViewGroup): ItemViewHolder<GithubUserListItem> {
        val binding = GithubUserGroupItemBinding.inflate(layoutInflater, container, false)
        val viewModel = githubUserGroupItemViewModelFactory.create()
        binding.viewModel = viewModel
        return GithubUserGroupViewHolder(binding, viewModel)
    }

}