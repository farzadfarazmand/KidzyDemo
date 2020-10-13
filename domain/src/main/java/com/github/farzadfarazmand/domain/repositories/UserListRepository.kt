package com.github.farzadfarazmand.domain.repositories

import com.github.farzadfarazmand.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserListRepository {
    suspend fun getUsersList(): Flow<List<User>>
}