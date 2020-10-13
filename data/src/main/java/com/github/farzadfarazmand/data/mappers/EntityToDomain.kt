package com.github.farzadfarazmand.data.mappers

import com.github.farzadfarazmand.data.models.entity.UserEntity
import com.github.farzadfarazmand.domain.models.User

internal fun UserEntity.toDomain(): User {
    return User(
        this.id,
        this.avatar,
        this.email,
        this.firstName,
        this.lastName
    )
}