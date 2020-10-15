package com.github.farzadfarazmand.domain.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val avatar: String,
    val email: String,
    val firstName: String,
    val lastName: String
)