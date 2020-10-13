package com.github.farzadfarazmand.kidzydemo.di.modules

import com.github.farzadfarazmand.data.api.UsersListApiService
import com.github.farzadfarazmand.data.repositories.UsersListRepository
import com.github.farzadfarazmand.data.source.UsersListDataSource
import com.github.farzadfarazmand.domain.usecases.UserListRepositoryUseCase
import dagger.Module
import dagger.Provides

@Module
open class UsersListModule {
    @Provides
    fun provideUsersListUseCase(
        usersListRepository: UsersListRepository
    ): UserListRepositoryUseCase =
        UserListRepositoryUseCase(usersListRepository)

    @Provides
    fun provideUsersListDataSource(
        apiService: UsersListApiService,
    ): UsersListDataSource =
        UsersListDataSource(apiService)
}