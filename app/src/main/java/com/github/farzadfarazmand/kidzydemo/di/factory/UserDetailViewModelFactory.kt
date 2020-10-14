package com.github.farzadfarazmand.kidzydemo.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.viewmodel.UserDetailViewModel

class UserDetailViewModelFactory(private val user: UserModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDetailViewModel(user) as T
    }


}