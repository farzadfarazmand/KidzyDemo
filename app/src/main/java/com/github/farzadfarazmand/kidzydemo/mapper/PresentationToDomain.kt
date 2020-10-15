package com.github.farzadfarazmand.kidzydemo.mapper

import com.github.farzadfarazmand.domain.models.User
import com.github.farzadfarazmand.kidzydemo.models.UserModel

fun UserModel.toDomain(): User {
    return User(
        this.id,
        this.avatar,
        this.email,
        this.firstName,
        this.lastName
    )
}