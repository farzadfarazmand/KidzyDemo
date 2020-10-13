package com.github.farzadfarazmand.domain.repositories

import com.github.farzadfarazmand.domain.models.User
import kotlinx.coroutines.flow.Flow

interface IBookmarkedUsersRepository {
    suspend fun getBookmarkedUsers(): Flow<List<User>>
}