package com.example.githubusersviewer.user.list.view.adapter.viewmodel.user

import androidx.lifecycle.MutableLiveData
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem

class GithubUserItemViewModel{

    val login = MutableLiveData<String>()
    val avatarUrl = MutableLiveData<String>()
    val isLastInGroup = MutableLiveData<Boolean>()

    fun setModel(githubUser: GithubUserListItem.GithubUser) {
        login.postValue(githubUser.login)
        avatarUrl.postValue(githubUser.avatarUrl)
        isLastInGroup.postValue(githubUser.lastInGroup)
    }

}