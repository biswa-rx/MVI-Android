package com.example.mvi_android.remote

import retrofit2.http.GET

interface BlogAPI {
    @GET("comments")
    suspend fun get(): List<BlogNetworkEntity>
}