package com.example.githubusersviewer.user.list.view.adapter.viewmodel.group

import androidx.lifecycle.MutableLiveData
import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem

class GithubUserGroupItemViewModel {

    val title = MutableLiveData<String>()

    fun setModel(githubUserGroup: GithubUserListItem.GithubUserGroup) {
        title.postValue(githubUserGroup.title)
    }

}