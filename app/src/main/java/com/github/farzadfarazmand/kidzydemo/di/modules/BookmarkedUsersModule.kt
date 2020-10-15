package com.github.farzadfarazmand.kidzydemo.di.modules

import com.github.farzadfarazmand.data.db.dao.UserDAO
import com.github.farzadfarazmand.data.repositories.BookmarkedUsersRepository
import com.github.farzadfarazmand.data.source.BookmarkedUserDataSource
import com.github.farzadfarazmand.domain.usecases.ChangeUserBookmarkStatusUseCase
import com.github.farzadfarazmand.domain.usecases.UserBookmarkedStatusUseCase
import dagger.Module
import dagger.Provides

@Module
class BookmarkedUsersModule {

    @Provides
    fun provideBookmarkedUsersUseCase(
        bookmarkedUsersRepository: BookmarkedUsersRepository
    ): UserBookmarkedStatusUseCase =
        UserBookmarkedStatusUseCase(bookmarkedUsersRepository)

    @Provides
    fun provideChangeUserBookmarkedStatusUseCase(
        bookmarkedUsersRepository: BookmarkedUsersRepository
    ): ChangeUserBookmarkStatusUseCase =
        ChangeUserBookmarkStatusUseCase(bookmarkedUsersRepository)

    @Provides
    fun provideBookmarkedUsersDataSource(
        userDAO: UserDAO,
    ): BookmarkedUserDataSource =
        BookmarkedUserDataSource(userDAO)
}