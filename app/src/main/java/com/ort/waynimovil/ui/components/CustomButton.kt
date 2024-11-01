package com.ort.waynimovil.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.ui.theme.WaynimovilTheme


@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .width(336.dp)
            .height(48.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun CustomButtonPreview(){
    WaynimovilTheme{
        CustomButton(
            text = "Prueba",
            onClick = { print("funca")}
        )
    }
}
