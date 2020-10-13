package com.github.farzadfarazmand.data.models.response

data class UsersListResponse(
    val data: MutableList<UserItem>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)