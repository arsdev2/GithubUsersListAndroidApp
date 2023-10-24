package com.example.githubusersviewer.user.list.view.adapter.model

sealed class GithubUserListItem {

    data class GithubUserGroup(
        val title: String
    ): GithubUserListItem()

    data class GithubUser (
        val login: String,
        val avatarUrl: String,
        val lastInGroup: Boolean = false
    ) : GithubUserListItem()

}