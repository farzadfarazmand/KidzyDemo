package com.github.farzadfarazmand.kidzydemo.models

import java.io.Serializable

data class UserModel(
    val id: Int,
    val avatar: String,
    val email: String,
    val fullName: String
) : Serializable