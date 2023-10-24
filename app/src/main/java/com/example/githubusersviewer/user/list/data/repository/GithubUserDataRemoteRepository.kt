package com.example.githubusersviewer.user.list.data.repository

import com.example.githubusersviewer.user.list.data.api.GithubUserDataApi
import com.example.githubusersviewer.user.list.data.model.NetworkGithubUser

class GithubUserDataRemoteRepository(
    private val githubUserDataApi: GithubUserDataApi
){

    suspend fun getGithubUserList(): List<NetworkGithubUser> {
        try {
            val response = githubUserDataApi.getUsers()
            if(!response.isSuccessful) {
                throw RuntimeException("Failed to load github users")
            }
            return response.body() ?: emptyList()
        }catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Failed to load github users")
        }
    }

}