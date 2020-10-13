package com.github.farzadfarazmand.data.repositories

import com.github.farzadfarazmand.data.mappers.toDomain
import com.github.farzadfarazmand.domain.models.User
import com.github.farzadfarazmand.domain.repositories.IBookmarkedUsersRepository
import com.github.farzadfarazmand.data.source.BookmarkedUserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookmarkedUsersRepository @Inject constructor(private val bookmarkedUserDataSource: BookmarkedUserDataSource) :
    IBookmarkedUsersRepository {
    override suspend fun getBookmarkedUsers(): Flow<List<User>> {
        return bookmarkedUserDataSource.getBookmarkedUsers().map {
            it.map { userEntity -> userEntity.toDomain() }
        }
    }
}