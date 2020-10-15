package com.github.farzadfarazmand.domain.usecases

import com.github.farzadfarazmand.domain.models.User
import com.github.farzadfarazmand.domain.repositories.IBookmarkedUsersRepository
import javax.inject.Inject

class ChangeUserBookmarkStatusUseCase @Inject constructor(private val bookmarkedUsersRepository: IBookmarkedUsersRepository) {
    suspend operator fun invoke(user: User, alreadyBookmark: Boolean) =
        bookmarkedUsersRepository.changeBookmarkedUserStatus(user, alreadyBookmark)
}