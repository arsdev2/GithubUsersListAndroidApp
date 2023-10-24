package com.example.githubusersviewer.user.list.data.api

import com.example.githubusersviewer.user.list.data.model.NetworkGithubUser
import retrofit2.Response
import retrofit2.http.GET

interface GithubUserDataApi {

    @GET("/users")
    suspend fun getUsers(): Response<List<NetworkGithubUser>>

}