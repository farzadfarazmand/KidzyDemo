package com.github.farzadfarazmand.domain.usecases

import com.github.farzadfarazmand.domain.repositories.IBookmarkedUsersRepository
import javax.inject.Inject

class BookmarkedUsersUseCase @Inject constructor(private val bookmarkedUsersRepository: IBookmarkedUsersRepository) {
    suspend operator fun invoke() = bookmarkedUsersRepository.getBookmarkedUsers()
}