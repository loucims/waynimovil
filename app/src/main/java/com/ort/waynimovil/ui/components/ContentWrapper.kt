package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContentWrapper(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFD1D1D7),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Preview
@Composable
fun ContentWrapperPreview() {
    ContentWrapper {
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        HorizontalDivider(
            modifier = Modifier.padding(0.dp, 16.dp)
        )
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        HorizontalDivider(
            modifier = Modifier.padding(0.dp, 16.dp)
        )
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")
        Text(text = "Hello, World!")

    }
}