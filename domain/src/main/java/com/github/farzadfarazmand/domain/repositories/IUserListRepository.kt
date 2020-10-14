package com.github.farzadfarazmand.domain.repositories

import com.github.farzadfarazmand.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IUserListRepository {
    suspend fun getUsersList(page: Int): Flow<List<User>>
}