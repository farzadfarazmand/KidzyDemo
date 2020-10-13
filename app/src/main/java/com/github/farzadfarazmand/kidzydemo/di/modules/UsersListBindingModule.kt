package com.github.farzadfarazmand.kidzydemo.di.modules

import com.github.farzadfarazmand.data.repositories.UsersListRepository
import com.github.farzadfarazmand.domain.repositories.IUserListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UsersListBindingModule {

    @Singleton
    @Binds
    abstract fun bindUsersListRepository(
        usersListRepository: UsersListRepository
    ): IUserListRepository

}