package com.github.farzadfarazmand.data.mappers

import com.github.farzadfarazmand.data.models.entity.UserEntity
import com.github.farzadfarazmand.domain.models.User

internal fun User.toEntity(): UserEntity {
    return UserEntity(
        this.id,
        this.avatar,
        this.email,
        this.firstName,
        this.lastName
    )
}