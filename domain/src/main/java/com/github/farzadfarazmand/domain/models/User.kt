package com.github.farzadfarazmand.domain.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val avatar: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String
)