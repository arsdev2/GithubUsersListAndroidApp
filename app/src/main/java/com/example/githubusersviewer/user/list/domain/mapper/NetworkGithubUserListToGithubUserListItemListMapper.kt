package com.example.githubusersviewer.user.list.domain.mapper

import com.example.githubusersviewer.user.list.data.model.NetworkGithubUser
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem

class NetworkGithubUserListToGithubUserListItemListMapper {

    fun map(networkGithubUserList: List<NetworkGithubUser>): List<GithubUserListItem.GithubUser> {
        return networkGithubUserList.mapNotNull {
            val avatarUrl = it.avatar_url
            val login = it.login
            if(login == null || avatarUrl == null) {
                return@mapNotNull null
            }
            return@mapNotNull GithubUserListItem.GithubUser(login, avatarUrl)
        }
    }
}