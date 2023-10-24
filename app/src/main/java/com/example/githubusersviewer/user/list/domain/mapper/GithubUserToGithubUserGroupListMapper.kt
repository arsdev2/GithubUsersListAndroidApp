package com.example.githubusersviewer.user.list.domain.mapper

import com.example.githubusersviewer.user.list.view.adapter.model.GithubUserListItem
import org.koin.core.component.getScopeId

class GithubUserToGithubUserGroupListMapper {


    fun map(githubUserListItems: List<GithubUserListItem.GithubUser>): List<GithubUserListItem> {
        var lastFirstChar: Char? = null
        val mutableGithubUserListItems = githubUserListItems.toMutableList()
        mutableGithubUserListItems.sortBy { it.login.lowercase() }
        val resultList =  mutableGithubUserListItems.flatMapIndexed { index, githubUser ->
            val resultList = mutableListOf<GithubUserListItem>()
            val firstChar = githubUser.login.firstOrNull()
            if(firstChar != null && lastFirstChar != firstChar) {
                lastFirstChar = firstChar
                resultList.add(GithubUserListItem.GithubUserGroup(firstChar.toString()))
            }
            if(index == mutableGithubUserListItems.size - 1) {
                resultList.add(githubUser.copy(lastInGroup = true))
            } else {
                resultList.add(githubUser)
            }
            resultList
        }.toMutableList()
        val iterator = resultList.iterator()
        var previousItem: GithubUserListItem? = null
        var previousItemIndex = -1
        var i = 0
        while(iterator.hasNext()) {
            val currentItem = iterator.next()
            val currentIndex = i
            i++
            if(currentItem is GithubUserListItem.GithubUserGroup && previousItem is GithubUserListItem.GithubUser) {
                resultList[previousItemIndex] = previousItem.copy(lastInGroup = true)
            }
            previousItem = currentItem
            previousItemIndex = currentIndex
        }
        return resultList
    }


}