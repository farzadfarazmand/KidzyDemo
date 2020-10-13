package com.github.farzadfarazmand.kidzydemo.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.farzadfarazmand.kidzydemo.di.ViewModelKey
import com.github.farzadfarazmand.kidzydemo.di.factory.ViewModelFactory
import com.github.farzadfarazmand.kidzydemo.viewmodel.UsersListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @IntoMap
    @Binds
    @ViewModelKey(UsersListViewModel::class)
    abstract fun bindUserListViewModel(usersListViewModel: UsersListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}