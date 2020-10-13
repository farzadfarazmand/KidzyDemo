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

}