package com.github.farzadfarazmand.data.api

import com.github.farzadfarazmand.data.models.response.UsersListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersListApiService {

    @GET("/api/users")
    suspend fun getUsersList(@Query("page") page: Int): UsersListResponse

}