package com.github.farzadfarazmand.data.models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserEntity")
class UserEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "avatar")
    val avatar: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String
)