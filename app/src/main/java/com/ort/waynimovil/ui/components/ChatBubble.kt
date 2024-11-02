package com.ort.waynimovil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatBubble(text: String, backgroundColor: Color = Color(0xFFDAE9FC)) {
    Row(
        modifier = Modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 100.dp))
            .padding(16.dp, 3.5.dp)
    ) {
        Text(
            style = MaterialTheme.typography.headlineSmall,
            text = text
        )
    }
}

@Preview
@Composable
fun ChatBubblePreview() {
    ChatBubble("UNA BILLETERA")
}

@Preview
@Composable
fun ChatBubbleEmojiPreview() {
    ChatBubble("\uD83D\uDE0A", Color(0xFF00A067))
}