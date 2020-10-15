package com.github.farzadfarazmand.kidzydemo.models

import java.io.Serializable

data class UserModel(
    val id: Int,
    val avatar: String,
    val email: String,
    val firstName: String,
    val lastName: String
) : Serializable {
    fun getFullName() = "$firstName $lastName"
}