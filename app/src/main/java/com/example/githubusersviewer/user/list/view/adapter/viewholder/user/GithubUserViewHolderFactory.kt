package com.example.githubusersviewer.user.list.view.adapter.viewholder.user

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.githubusersviewer.databinding.GithubUserItemBinding
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import com.example.githubusersviewer.user.list.view.adapter.viewmodel.user.GithubUserItemViewModelFactory
import com.example.githubusersviewer.view.base.ItemViewHolder

class GithubUserViewHolderFactory(
    private val layoutInflater: LayoutInflater,
    private val githubUserItemViewModelFactory: GithubUserItemViewModelFactory
) {

    fun create(container: ViewGroup): ItemViewHolder<GithubUserListItem.GithubUser> {
        val binding = GithubUserItemBinding.inflate(layoutInflater, container, false)
        val viewModel = githubUserItemViewModelFactory.create()
        binding.viewModel = viewModel
        return GithubUserViewHolder(binding, viewModel)
    }

}