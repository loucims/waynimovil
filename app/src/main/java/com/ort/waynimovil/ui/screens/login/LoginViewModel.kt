package com.ort.waynimovil.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.waynimovil.data.repository.FakeStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: FakeStoreRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> get() = _loginState

    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading
        viewModelScope.launch {
            val result = repository.loginUser(username, password)
            _loginState.value = when {
                result.isSuccess -> {
                    val loginResponse = result.getOrNull()
                    if (loginResponse != null) {
                        LoginState.Success(loginResponse.token)
                    } else {
                        LoginState.Error("Credenciales invalidas")
                    }
                }
                result.isFailure -> {
                    val exception = result.exceptionOrNull()
                    LoginState.Error(exception?.message ?: "Credenciales invalidas")
                }
                else -> {
                    LoginState.Error("Credenciales invalidas")
                }
            }
        }
    }

    fun resetState() {
        _loginState.value = LoginState.Idle
    }
}

//Manejas los estados de la pantalla de login
sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data class Success(val token: String) : LoginState()
    data class Error(val message: String) : LoginState()
}