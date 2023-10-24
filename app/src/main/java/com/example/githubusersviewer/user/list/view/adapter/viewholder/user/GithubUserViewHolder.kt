package com.example.githubusersviewer.user.list.view.adapter.viewholder.user

import com.bumptech.glide.Glide
import com.example.githubusersviewer.databinding.GithubUserItemBinding
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import com.example.githubusersviewer.user.list.view.adapter.viewmodel.user.GithubUserItemViewModel
import com.example.githubusersviewer.view.base.ItemViewHolder
import com.example.githubusersviewer.view.utils.getLifecycleOwner

class GithubUserViewHolder(
    private val binding: GithubUserItemBinding,
    private val githubUserItemViewModel: GithubUserItemViewModel
): ItemViewHolder<GithubUserListItem.GithubUser>(binding.root) {

    init {
        githubUserItemViewModel.avatarUrl.observe(itemView.context.getLifecycleOwner()) {
            Glide.with(itemView.context)
                .load(it)
                .circleCrop()
                .into(binding.userAvatar);
        }
    }

    override fun onBind(item: GithubUserListItem.GithubUser) {
        githubUserItemViewModel.setModel(item)
        binding.lifecycleOwner = itemView.context.getLifecycleOwner()
        binding.executePendingBindings()
    }

}