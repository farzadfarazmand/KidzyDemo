package com.github.farzadfarazmand.data.models.response

import com.github.farzadfarazmand.domain.models.User
import com.google.gson.annotations.SerializedName

data class UserItem(
    val id: Int,
    val avatar: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String
)