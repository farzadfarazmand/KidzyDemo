package com.github.farzadfarazmand.kidzydemo.di.modules

import com.github.farzadfarazmand.data.api.HttpClient
import com.github.farzadfarazmand.data.api.UsersListApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
open class UsersListApiModule {

    @Provides
    open fun provideOkHttpClient(): OkHttpClient {
        return HttpClient.createOkHttpClient()
    }

    @Singleton
    @Provides
    open fun provideUsersListApi(retrofit: Retrofit): UsersListApiService {
        return retrofit.create(UsersListApiService::class.java)
    }

    @Singleton
    @Provides
    open fun provideRetrofit(okHttpClient: OkHttpClient, @Named("baseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Named("baseUrl")
    open fun provideBaseUrl(): String = "https://reqres.in/"

}