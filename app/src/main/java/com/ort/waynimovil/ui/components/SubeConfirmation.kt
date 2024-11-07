package com.ort.waynimovil.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.R

@Composable
fun SubeConfirmation(onNext: () -> Unit) {


    val subeImage: Painter = painterResource(id = R.drawable.logo_sube)


    Text(
        textAlign = TextAlign.Center,
        text = "Verificá que la información sea \ncorrecta:",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Medium
    )

    Spacer(modifier = Modifier.height(20.dp))

    ContentWrapper{
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = subeImage,
                contentDescription = "Tarjeta SUBE",
                modifier = Modifier
                    .width(140.dp)
                    .height(80.dp)
            )


            HorizontalDivider(modifier = Modifier.padding(0.dp, 15.dp))

            Text(
                text = "Tarjeta No: 6061 3580 2384 9041",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            HorizontalDivider(modifier = Modifier.padding(0.dp, 15.dp))

            Text(
                text = "$ 200,00",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        }
    }


    Spacer(modifier = Modifier.height(20.dp))


    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        CustomButton(
            text = "Continuar",
            onClick = {
                onNext()
            }
        )

    }

}
