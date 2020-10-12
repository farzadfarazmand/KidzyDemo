package com.github.farzadfarazmand.kidzydemo.view.activtiy

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun setLayoutId(): Int

    abstract fun initComponents(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initComponents(savedInstanceState)
    }

}