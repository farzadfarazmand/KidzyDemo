package com.github.farzadfarazmand.kidzydemo.di.modules

import android.content.Context
import androidx.room.Room
import com.github.farzadfarazmand.data.db.AppDatabase
import com.github.farzadfarazmand.data.db.dao.UserDAO
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * This is a Dagger provider module
 */
@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideDb(context: Context, @Named("databaseName") dbName: String): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Named("databaseName")
    fun provideDatabaseName(): String = "kidzyDemo.db"

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDAO =
        appDatabase.userDAO()
}