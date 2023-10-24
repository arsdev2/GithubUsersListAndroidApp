package com.example.githubusersviewer.user.list.view.di

import android.content.Context
import com.example.githubusersviewer.user.list.view.adapter.GithubUserListAdapter
import com.example.githubusersviewer.user.list.view.adapter.viewholder.group.GithubUserGroupViewHolderFactory
import com.example.githubusersviewer.user.list.view.adapter.viewholder.user.GithubUserViewHolderFactory
import com.example.githubusersviewer.user.list.view.adapter.viewmodel.group.GithubUserGroupItemViewModelFactory
import com.example.githubusersviewer.user.list.view.adapter.viewmodel.user.GithubUserItemViewModelFactory
import com.example.githubusersviewer.user.list.view.viewmodel.GithubUserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val githubUserListPresentationModule = module {

    factory { GithubUserItemViewModelFactory() }
    factory { GithubUserGroupItemViewModelFactory() }

    factory { (context: Context) ->
        GithubUserGroupViewHolderFactory(get(parameters = { parametersOf(context) }), get())
    }
    factory { (context: Context) ->
        GithubUserViewHolderFactory(get(parameters = { parametersOf(context) }), get())
    }

    factory { (context: Context) ->
        GithubUserListAdapter(get(parameters = { parametersOf(context) }), get(parameters = { parametersOf(context) }))
    }

    viewModel {
        GithubUserListViewModel(get())
    }

}