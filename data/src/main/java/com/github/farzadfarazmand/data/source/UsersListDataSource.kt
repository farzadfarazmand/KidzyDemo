package com.github.farzadfarazmand.data.source

import com.github.farzadfarazmand.data.api.UsersListApiService
import com.github.farzadfarazmand.data.models.response.UsersListResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsersListDataSource @Inject constructor(private val apiService: UsersListApiService) {

    suspend fun getUsersFromApi(page: Int): Flow<UsersListResponse> {

        val response = apiService.getUsersList(page)
        return flow { emit(response) }


    }
}