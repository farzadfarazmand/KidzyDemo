package com.github.farzadfarazmand.kidzydemo.util

import androidx.lifecycle.MutableLiveData


fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }