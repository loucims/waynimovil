package com.ort.waynimovil.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.waynimovil.data.repository.FakeStoreRepository
import com.ort.waynimovil.ui.screens.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val fakeStoreRepository: FakeStoreRepository
) : ViewModel() {

    private val _firstName = MutableStateFlow<String?>(null)
    val firstName: StateFlow<String?> = _firstName

    private val _lastName = MutableStateFlow<String?>(null)
    val lastName: StateFlow<String?> = _lastName

    private val _loginToken = MutableStateFlow<String?>(null)
    val loginToken: StateFlow<String?> = _loginToken

    private val _userDataFetched = MutableStateFlow(false)
    val userDataFetched: StateFlow<Boolean> = _userDataFetched

    fun fetchUserData(userId: Int) {
        viewModelScope.launch {
            try {
                println("FETCHEANDO DATAAAA")
                val userResult = fakeStoreRepository.getUserInfo(userId)
                if (userResult.isSuccess) {
                    println("IS SUCCESS!!!")
                    val userResponse = userResult.getOrNull()
                    if (userResponse != null) {
                        println(userResponse)
                        _firstName.value = userResponse.name.firstname
                        _lastName.value = userResponse.name.lastname
                        _userDataFetched.value = true
                    }
                } else {
                    val exception = userResult.exceptionOrNull()
                    println("ERROR: $exception")
                    _firstName.value = "Sin nombre"
                    _lastName.value = ""
                    _userDataFetched.value = true
                }
            } catch (e: Exception) {
                println("No funco.. :(")
                println("ERROR: $e")
                _userDataFetched.value = true
            }
        }
    }

    fun setLoginToken(token: String) {
        _loginToken.value = token
    }

    fun logout() {
        _loginToken.value = null
        _firstName.value = null
        _lastName.value = null
        _userDataFetched.value = false
    }
}