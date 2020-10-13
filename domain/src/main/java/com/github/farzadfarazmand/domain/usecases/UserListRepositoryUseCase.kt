package com.github.farzadfarazmand.domain.usecases

import com.github.farzadfarazmand.domain.repositories.UserListRepository
import javax.inject.Inject

class UserListRepositoryUseCase @Inject constructor(private val userListRepository: UserListRepository) {
    suspend operator fun invoke() = userListRepository.getUsersList()
}