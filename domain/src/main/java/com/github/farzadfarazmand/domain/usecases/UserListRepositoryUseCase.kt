package com.github.farzadfarazmand.domain.usecases

import com.github.farzadfarazmand.domain.repositories.IUserListRepository
import javax.inject.Inject

class UserListRepositoryUseCase @Inject constructor(private val userListRepository: IUserListRepository) {
    suspend operator fun invoke() = userListRepository.getUsersList()
}