package com.github.farzadfarazmand.kidzydemo.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.farzadfarazmand.domain.usecases.UserListRepositoryUseCase
import com.github.farzadfarazmand.kidzydemo.mapper.toPresentation
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.viewmodel.common.EmptyList
import com.github.farzadfarazmand.kidzydemo.viewmodel.common.Loading
import com.github.farzadfarazmand.kidzydemo.viewmodel.common.Success
import com.github.farzadfarazmand.kidzydemo.viewmodel.common.UiStateViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val userListRepositoryUseCase: UserListRepositoryUseCase
) : UiStateViewModel() {

    private var pageNum = 1
    var hasMoreItem = true

    val usersList: LiveData<MutableList<UserModel>>
        get() = _userList

    private var _userList: MutableLiveData<MutableList<UserModel>> =
        MutableLiveData()

    init {
        _userList.value = arrayListOf()
    }

    fun loadUsers() {
        if (hasMoreItem && _uiState.value != Loading) {

            if (isFirstPage())
                _uiState.value = Loading

            viewModelScope.launch(handler) {

                userListRepositoryUseCase.invoke(pageNum).collect { results ->
                    if (results.isNullOrEmpty()) {
                        if (isFirstPage()) {
                            _uiState.value = EmptyList
                        }
                        hasMoreItem = false
                    } else {
                        val newUsers = results.map { it.toPresentation() }
                        _userList.value?.addAll(newUsers)
                        _userList.value = _userList.value
                    }
                }
                _uiState.value = Success
                pageNum += 1
            }
        }
    }

    private fun isFirstPage(): Boolean = pageNum == 1

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {

    }
}
