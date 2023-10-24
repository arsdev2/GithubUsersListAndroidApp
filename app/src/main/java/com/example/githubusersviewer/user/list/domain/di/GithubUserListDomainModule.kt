package com.example.githubusersviewer.user.list.domain.di

import com.example.githubusersviewer.user.list.domain.interactor.GetGithubUsers
import com.example.githubusersviewer.user.list.domain.mapper.GithubUserToGithubUserGroupListMapper
import com.example.githubusersviewer.user.list.domain.mapper.NetworkGithubUserListToGithubUserListItemListMapper
import org.koin.dsl.module

val githubUserListDomainModule = module {

    factory { NetworkGithubUserListToGithubUserListItemListMapper() }
    factory { GithubUserToGithubUserGroupListMapper() }
    factory { GetGithubUsers(get(), get(), get()) }
}