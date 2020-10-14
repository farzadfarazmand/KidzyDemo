package com.github.farzadfarazmand.kidzydemo.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.farzadfarazmand.domain.usecases.UserListRepositoryUseCase
import com.github.farzadfarazmand.kidzydemo.mapper.toPresentation
import com.github.farzadfarazmand.kidzydemo.models.UserModel
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

    val usersList: LiveData<List<UserModel>>
        get() = _userList

    private var _userList: MutableLiveData<List<UserModel>> =
        MutableLiveData()

    fun loadUsers() {
//        if (hasMoreItem && _uiState.value != Loading) {
//            _uiState.value = Loading
            viewModelScope.launch(handler) {

                userListRepositoryUseCase.invoke().collect { results ->
                    _userList.value = results.map { it.toPresentation() }
                }
                _uiState.value = Success
            }
//        }
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {

    }
}
