package com.github.farzadfarazmand.data.db.dao

import androidx.room.*
import com.github.farzadfarazmand.data.models.entity.UserEntity

@Dao
interface UserDAO {

    @Query("SELECT * FROM UserEntity")
    suspend fun allBookmarks(): MutableList<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id = :id")
    suspend fun getUser(id: Int): UserEntity?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bookmarkUser(user: UserEntity)

    @Delete
    suspend fun removeBookmarkedUser(user: UserEntity)
}