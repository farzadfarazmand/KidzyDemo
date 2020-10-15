package com.github.farzadfarazmand.data.repositories

import com.github.farzadfarazmand.data.mappers.toEntity
import com.github.farzadfarazmand.data.source.BookmarkedUserDataSource
import com.github.farzadfarazmand.domain.models.User
import com.github.farzadfarazmand.domain.repositories.IBookmarkedUsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkedUsersRepository @Inject constructor(private val bookmarkedUserDataSource: BookmarkedUserDataSource) :
    IBookmarkedUsersRepository {

    override suspend fun isUserBookmarked(userId: Int): Flow<Boolean> {
        return bookmarkedUserDataSource.isUserBookmarked(userId)
    }

    override suspend fun changeBookmarkedUserStatus(
        user: User,
        alreadyBookmarked: Boolean
    ): Flow<Boolean> {
        return bookmarkedUserDataSource.changeUserBookmarkStatus(user.toEntity(), alreadyBookmarked)
    }
}