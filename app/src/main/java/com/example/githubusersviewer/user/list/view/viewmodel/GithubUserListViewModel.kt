package com.example.githubusersviewer.user.list.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersviewer.user.list.domain.interactor.GetGithubUsers
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubUserListViewModel(
    private val getGithubUsers: GetGithubUsers
) : ViewModel() {

    val githubUserGroupList = MutableLiveData<List<GithubUserListItem>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val users = getGithubUsers()
            githubUserGroupList.postValue(users)
        }
    }


}