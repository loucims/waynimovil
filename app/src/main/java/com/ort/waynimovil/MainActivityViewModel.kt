package com.ort.waynimovil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.waynimovil.data.model.LoginResponse
import com.ort.waynimovil.data.model.Transaction
import com.ort.waynimovil.data.model.UserResponse
import com.ort.waynimovil.data.repository.BancoRepository
import com.ort.waynimovil.data.repository.FakeStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private var fakeStoreRepository: FakeStoreRepository,
    private var bancoRepository: BancoRepository
): ViewModel() {

    private val _loginResponse = MutableStateFlow<LoginResponse?>(null)
    val loginResponse: StateFlow<LoginResponse?> = _loginResponse

    private val _userInfo = MutableStateFlow<UserResponse?>(null)
    val userInfo: StateFlow<UserResponse?> = _userInfo

    private val _creditCardTransactions = MutableStateFlow<List<Transaction>?>(null)
    val creditCardTransactions: StateFlow<List<Transaction>?> = _creditCardTransactions

//    fun loginUser(username: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val response = fakeStoreRepository.loginUser(username, password)
//                _loginResponse.value = response
//            } catch (e: Exception) {
//                println("ERROR: $e")
//            }
//        }
//    }
//
//    fun getUserInfo(id: Int) {
//        viewModelScope.launch {
//            try {
//                val response = fakeStoreRepository.getUserInfo(id)
//                _userInfo.value = response
//            } catch (e: Exception) {
//                println("ERROR: $e")
//            }
//        }
//    }


    fun getCreditCardTransactionsForUser(id: String) {
        viewModelScope.launch {
            try {
                val transactions = bancoRepository.getCreditCardTransactionsForUser(id)
                _creditCardTransactions.value = transactions
            } catch (e: Exception) {
                println("ERROR: $e")
            }
        }
    }
}