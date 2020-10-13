package com.github.farzadfarazmand.kidzydemo.viewmodel

import androidx.lifecycle.ViewModel
import com.github.farzadfarazmand.domain.usecases.UserListRepositoryUseCase
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val userListRepositoryUseCase: UserListRepositoryUseCase
) : ViewModel() {



}