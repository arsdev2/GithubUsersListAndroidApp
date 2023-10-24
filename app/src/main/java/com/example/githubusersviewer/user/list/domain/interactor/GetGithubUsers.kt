package com.example.githubusersviewer.user.list.domain.interactor

import com.example.githubusersviewer.user.list.data.model.NetworkGithubUser
import com.example.githubusersviewer.user.list.data.repository.GithubUserDataRemoteRepository
import com.example.githubusersviewer.user.list.domain.mapper.GithubUserToGithubUserGroupListMapper
import com.example.githubusersviewer.user.list.domain.mapper.NetworkGithubUserListToGithubUserListItemListMapper
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem

class GetGithubUsers(
    private val githubUserDataRemoteRepository: GithubUserDataRemoteRepository,
    private val networkGithubUserListToGithubUserListItemListMapper: NetworkGithubUserListToGithubUserListItemListMapper,
    private val githubUserToGithubUserGroupListMapper: GithubUserToGithubUserGroupListMapper
) {

    suspend operator fun invoke(): List<GithubUserListItem> {
        return githubUserDataRemoteRepository.getGithubUserList().toMutableList().apply {
            removeIf { it.login == null || it.avatar_url == null }
            sortedBy { it.login!!.first() }
        }.let { networkGithubUserListToGithubUserListItemListMapper.map(it) }.let { githubUserToGithubUserGroupListMapper.map(it) }
    }

}