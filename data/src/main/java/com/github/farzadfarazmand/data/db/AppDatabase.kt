package com.github.farzadfarazmand.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.farzadfarazmand.data.db.dao.UserDAO
import com.github.farzadfarazmand.data.models.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO
}