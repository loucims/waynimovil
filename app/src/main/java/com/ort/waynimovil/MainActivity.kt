package com.ort.waynimovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ort.waynimovil.ui.theme.WaynimovilTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaynimovilTheme {
                val viewModel: MainActivityViewModel = hiltViewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestingComponent(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun TestingComponent(modifier: Modifier = Modifier, viewModel: MainActivityViewModel) {
    val loginResponse by viewModel.loginResponse.collectAsState()
    val userInfo by viewModel.userInfo.collectAsState()
    val creditCardTransactions by viewModel.creditCardTransactions.collectAsState()

    Column(modifier = modifier) {
        Text(text = "Testeando cositas de retrofit...")

        Button(onClick = {
            viewModel.loginUser("mor_2314", "83r5^_")
        }) {
            Text("Login retrofit")
        }
        loginResponse?.let {
            Text("Respuesta: ${it.token}")
        }

        Button(onClick = {
            viewModel.getUserInfo(1)
        }) {
            Text("User info retrofit")
        }
        userInfo?.let {
            Text("Respuesta: ${it.name}")
        }

        Button(onClick = {
            viewModel.getCreditCardTransactionsForUser("12345")
        }) {
            Text("Transacciones firestore")
        }
        creditCardTransactions?.let {
            LazyColumn {
                items(it) { transaction ->
                    Text("Transacción: ${transaction.amount}")
                }
            }
        }
    }
}