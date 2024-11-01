package com.ort.waynimovil.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.R
import com.ort.waynimovil.ui.theme.WaynimovilTheme

@Composable
fun BankCard(cardNumber: String, expirationDate: String, hidden: Boolean) {

    fun obfuscateCardNumber(cardNumber: String): String {
        return "${cardNumber.take(4)} **** **** ${cardNumber.takeLast(4)}"
    }

    Surface(
        modifier = Modifier
            .width(336.dp)
            .height(205.dp)
            .padding(0.dp),
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(size = 12.dp)

    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.background_card),
            contentDescription = "Card background"
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp, 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.7f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = if (hidden) obfuscateCardNumber(cardNumber) else cardNumber,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = expirationDate,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(0.dp,0.dp, 0.dp, 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    modifier = Modifier.width(50.dp),
                    painter = painterResource(id = R.drawable.logo_waynimovil_minimized),
                    contentDescription = "Card background"
                )

                Image(
                    modifier = Modifier.width(50.dp),
                    painter = painterResource(id = R.drawable.logo_mastercard),
                    contentDescription = "Card background"
                )
            }
        }
    }
}

@Preview
@Composable
fun BankCardPreview() {
    WaynimovilTheme {
        BankCard("1234 5678 9012 3456", "12/23", true)
    }
}