package com.github.farzadfarazmand.data.api

import com.github.farzadfarazmand.data.models.response.UsersListResponse
import retrofit2.http.GET

interface UsersListApiService {

    @GET("")
    suspend fun getUsersList(): UsersListResponse

}