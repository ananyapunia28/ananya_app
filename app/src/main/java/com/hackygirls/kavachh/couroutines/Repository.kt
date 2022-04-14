package com.hackygirls.kavachh.couroutines

import retrofit2.Response

class Repository {
    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }
    suspend fun getPost(): Response<Profile> {
        return RetrofitInstance.api.getPost()
    }
}