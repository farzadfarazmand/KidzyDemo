package com.github.farzadfarazmand.kidzydemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.github.farzadfarazmand.kidzydemo.di.AppComponent
import com.github.farzadfarazmand.kidzydemo.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class KidzyDemoApplication : Application() {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(applicationContext)

        getApplicationComponent().inject(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    open fun getApplicationComponent(): AppComponent = appComponent

}