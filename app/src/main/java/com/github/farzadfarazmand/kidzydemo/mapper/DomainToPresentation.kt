package com.github.farzadfarazmand.kidzydemo.mapper

import com.github.farzadfarazmand.domain.models.User
import com.github.farzadfarazmand.kidzydemo.models.UserModel

fun User.toPresentation(): UserModel {
    return UserModel(
        this.id,
        this.avatar,
        this.email,
        this.getFullName()
    )
}