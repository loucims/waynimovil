package com.ort.waynimovil.ui.screens.main.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ort.waynimovil.data.model.Transaction
import com.ort.waynimovil.data.repository.BancoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val bancoRepository: BancoRepository
) : ViewModel() {

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchTransactions(userId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _transactions.value = bancoRepository.getCreditCardTransactionsForUser(userId)
            _isLoading.value = false
        }
    }
}
