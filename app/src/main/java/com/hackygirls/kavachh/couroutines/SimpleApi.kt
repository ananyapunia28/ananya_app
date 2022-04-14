package com.hackygirls.kavachh.couroutines

import com.hackygirls.kavachh.dataClass.Signup
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SimpleApi {
    @POST("Register/Lender/")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>
    @GET("Lender/Profile")
    suspend fun getPost(): Response<Profile>
}