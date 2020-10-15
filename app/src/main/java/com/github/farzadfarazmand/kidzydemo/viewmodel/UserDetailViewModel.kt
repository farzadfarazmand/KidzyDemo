package com.github.farzadfarazmand.kidzydemo.viewmodel

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.farzadfarazmand.domain.usecases.ChangeUserBookmarkStatusUseCase
import com.github.farzadfarazmand.domain.usecases.UserBookmarkedStatusUseCase
import com.github.farzadfarazmand.kidzydemo.mapper.toDomain
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.util.default
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(
    private val userBookmarkedStatusUseCase: UserBookmarkedStatusUseCase,
    private val changeUserBookmarkedStatusUseCase: ChangeUserBookmarkStatusUseCase
) : ViewModel() {

    lateinit var user: UserModel
    val isBookmarked = MutableLiveData<Boolean>().default(false)

    fun setUserBookmarkedStatus() {
        viewModelScope.launch {
            userBookmarkedStatusUseCase.invoke(user.id).collect { alreadyBookmarked ->
                isBookmarked.value = alreadyBookmarked
            }
        }
    }

    fun changeUserBookmarkedStatus() {
        viewModelScope.launch {
            changeUserBookmarkedStatusUseCase.invoke(user.toDomain(), isBookmarked.value!!)
                .collect { bookmarkNewStatus ->
                    isBookmarked.value = bookmarkNewStatus
                }
        }
    }

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