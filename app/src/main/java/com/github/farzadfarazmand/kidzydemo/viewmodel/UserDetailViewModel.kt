package com.github.farzadfarazmand.kidzydemo.viewmodel

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.github.farzadfarazmand.kidzydemo.models.UserModel

class UserDetailViewModel(val user: UserModel) : ViewModel() {

    fun createEmailIntent(subject: String = ""): Intent {
        return Intent(Intent.ACTION_SENDTO).apply {
            data = (Uri.parse("mailto:${user.email}"))
                .buildUpon()
                .appendQueryParameter(
                    "subject", subject
                ).appendQueryParameter(
                    "to", user.email
                )
                .build()
        }
    }


}