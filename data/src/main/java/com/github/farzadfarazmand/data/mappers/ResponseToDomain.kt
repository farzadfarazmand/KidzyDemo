package com.github.farzadfarazmand.data.mappers

import com.github.farzadfarazmand.data.models.response.UserItem
import com.github.farzadfarazmand.domain.models.User

internal fun UserItem.toDomain(): User {
    return User(
        this.id,
        this.avatar,
        this.email,
        this.firstName,
        this.lastName
    )
}