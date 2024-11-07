package com.ort.waynimovil.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ort.waynimovil.R
import com.ort.waynimovil.ui.components.ContentWrapper
import com.ort.waynimovil.ui.components.CustomButton
import com.ort.waynimovil.ui.components.Header
import com.ort.waynimovil.ui.components.ServicioGrid
import com.ort.waynimovil.ui.components.ServicioItemData
import com.ort.waynimovil.ui.components.SubeConfirmation
import com.ort.waynimovil.ui.components.SuccesfulSube
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicePaymentScreen() {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { false }
    )
    val scope = rememberCoroutineScope()
    var isSheetOpen by remember { mutableStateOf(false) }
    var isFirstLaunch by remember { mutableStateOf(true) }

    var showSuccessMessage by remember { mutableStateOf(false) }


    val items = listOf(
        ServicioItemData(R.drawable.icono_colectivo, "CARGAR SUBE") {
            scope.launch {
                isSheetOpen = true
            }
        },
        ServicioItemData(R.drawable.icono_celular, "RECARGAR CELULAR", {}),
        ServicioItemData(R.drawable.icono_pago_servicio, "PAGO DE SERVICIO", {}),
        ServicioItemData(R.drawable.icono_antena, "DIRECT TV PREPAGO", {}),
    )

    LaunchedEffect(isSheetOpen) {
        //Ni YO, se por que esto funciona, pero funciona. arregla la animacion del principio
        if (isSheetOpen) {
            if (isFirstLaunch) {
                isFirstLaunch = false
                sheetState.show()
            } else {
                sheetState.show()
            }
        }
    }

    fun handleClose() {
        scope.launch {
            sheetState.hide()
            isSheetOpen = false
        }
    }

    fun handleNext() {
        if (showSuccessMessage) {
            showSuccessMessage = false
            handleClose()
        } else {
            showSuccessMessage = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(text = "Pago de servicios")
        ServicioGrid(items = items, verticalSpacing = 16, horizontalSpacing = 16)
    }

    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { isSheetOpen = false },
            sheetState = sheetState,
            shape = RoundedCornerShape(0.dp),
            dragHandle = null
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                TopBar(
                    shouldShowBackArrow = showSuccessMessage,
                    headerText = "Cargar Sube",
                    onBackArrowClick = { handleClose() },
                    onXClick = { handleClose() }
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(start = 12.dp, end = 12.dp, bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (showSuccessMessage) {

                        SuccesfulSube { handleNext() }
                    } else {
                        Spacer(modifier = Modifier.height(40.dp))
                        SubeConfirmation { handleNext() }
                    }
                }
            }
        }
    }
}


@Composable
fun TopBar(shouldShowBackArrow: Boolean, headerText: String, onBackArrowClick: () -> Unit, onXClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 10.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (shouldShowBackArrow) {
            IconButton(onClick = { onBackArrowClick() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        } else {
            Box(modifier = Modifier.width(48.dp)) // Para mantener el espacio
        }
        Text(
            text = "Cargar Sube",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        IconButton(onClick = { onXClick() }) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cerrar",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}