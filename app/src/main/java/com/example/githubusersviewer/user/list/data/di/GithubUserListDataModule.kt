package com.example.githubusersviewer.user.list.data.di

import com.example.githubusersviewer.user.list.data.api.GithubUserDataApi
import com.example.githubusersviewer.user.list.data.repository.GithubUserDataRemoteRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val githubUserListDataModule = module {

    single { get<Retrofit>().create(GithubUserDataApi::class.java) }

    factory {
        GithubUserDataRemoteRepository(get())
    }

}