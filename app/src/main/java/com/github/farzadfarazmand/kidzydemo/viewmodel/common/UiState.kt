package com.github.farzadfarazmand.kidzydemo.viewmodel.common

sealed class UiState

object Loading : UiState()
object Success : UiState()
class Error(val error: Throwable) : UiState()