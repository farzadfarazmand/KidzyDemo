package com.github.farzadfarazmand.kidzydemo.di.modules

import com.github.farzadfarazmand.data.repositories.BookmarkedUsersRepository
import com.github.farzadfarazmand.domain.repositories.IBookmarkedUsersRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BookmarkedUsersBindingModule {

    @Singleton
    @Binds
    abstract fun bindBookmarkedUsersRepository(
        bookmarkedUsersRepository: BookmarkedUsersRepository
    ): IBookmarkedUsersRepository
}