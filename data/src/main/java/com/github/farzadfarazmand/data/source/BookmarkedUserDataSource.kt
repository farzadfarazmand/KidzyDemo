package com.github.farzadfarazmand.data.source

import com.github.farzadfarazmand.data.db.dao.UserDAO
import com.github.farzadfarazmand.data.models.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookmarkedUserDataSource @Inject constructor(private val userDAO: UserDAO) {

    suspend fun getBookmarkedUsers(): Flow<MutableList<UserEntity>> {
        return flow { emit(userDAO.allBookmarks()) }
    }

    suspend fun isUserBookmarked(userId: Int): Flow<Boolean> {
        val user = userDAO.getUser(userId)
        user?.let {
            return flow { emit(true) }
        } ?: kotlin.run {
            return flow { emit(false) }
        }
    }

    suspend fun changeUserBookmarkStatus(
        user: UserEntity,
        alreadyBookmarked: Boolean
    ): Flow<Boolean> {
        if (alreadyBookmarked) {
            userDAO.removeBookmarkedUser(user)
        } else {
            userDAO.bookmarkUser(user)
        }
        return flow { emit(!alreadyBookmarked) }
    }

}