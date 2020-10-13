package com.github.farzadfarazmand.data.repositories

import com.github.farzadfarazmand.data.mappers.toDomain
import com.github.farzadfarazmand.domain.models.User
import com.github.farzadfarazmand.domain.repositories.IUserListRepository
import com.github.farzadfarazmand.data.source.UsersListDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UsersListRepository @Inject constructor(private val usersListDataSource: UsersListDataSource) : IUserListRepository {
    override suspend fun getUsersList(): Flow<List<User>> {
        return usersListDataSource.getUsersFromApi().map {
            it.data.map { userItem -> userItem.toDomain() }
        }
    }
}