package com.github.farzadfarazmand.kidzydemo.di

import android.content.Context
import com.github.farzadfarazmand.kidzydemo.KidzyDemoApplication
import com.github.farzadfarazmand.kidzydemo.di.modules.ActivityBuilderModule
import com.github.farzadfarazmand.kidzydemo.di.modules.ApplicationModule
import com.github.farzadfarazmand.kidzydemo.di.modules.UsersListApiModule
import com.github.farzadfarazmand.kidzydemo.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        UsersListApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: KidzyDemoApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}

