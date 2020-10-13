package com.github.farzadfarazmand.kidzydemo.di.modules

import com.github.farzadfarazmand.kidzydemo.di.ActivityScope
import com.github.farzadfarazmand.kidzydemo.di.modules.base.BaseBindingModule
import com.github.farzadfarazmand.kidzydemo.di.modules.base.BaseModule
import com.github.farzadfarazmand.kidzydemo.view.activtiy.BaseActivity
import com.github.farzadfarazmand.kidzydemo.view.activtiy.UsersListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseBindingModule::class, UsersListBindingModule::class, BookmarkedUsersBindingModule::class])
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [BaseModule::class])
    abstract fun provideBaseActivity(): BaseActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [UsersListModule::class])
    abstract fun provideUsersListActivity(): UsersListActivity
}