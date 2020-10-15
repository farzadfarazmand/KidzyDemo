package com.github.farzadfarazmand.domain.usecases

import com.github.farzadfarazmand.domain.repositories.IBookmarkedUsersRepository
import javax.inject.Inject

class UserBookmarkedStatusUseCase @Inject constructor(private val bookmarkedUsersRepository: IBookmarkedUsersRepository) {
    suspend operator fun invoke(userId: Int) = bookmarkedUsersRepository.isUserBookmarked(userId)
}