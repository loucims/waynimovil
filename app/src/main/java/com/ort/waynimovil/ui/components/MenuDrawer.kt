package com.ort.waynimovil.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection.Ltr
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ort.waynimovil.R
import com.ort.waynimovil.ThemeViewModel
import com.ort.waynimovil.ui.screens.UserViewModel
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun MenuDrawer(onLogoutClick: () -> Unit, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    val userViewModel: UserViewModel = hiltViewModel()
    val firstName by userViewModel.firstName.collectAsState()
    val lastName by userViewModel.lastName.collectAsState()
    val token by userViewModel.loginToken.collectAsState()

    val themeViewModel: ThemeViewModel = hiltViewModel()
    val isDarkMode by themeViewModel.isDarkTheme.collectAsState()

    CompositionLocalProvider(LocalLayoutDirection provides  Ltr) {
        ModalDrawerSheet(
            modifier = Modifier
                .then(
                    if (drawerState.targetValue == DrawerValue.Open) Modifier.fillMaxSize() else Modifier
                )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(top = 24.dp, start = 12.dp, end = 12.dp, bottom = 90.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Header(text = "Mi perfil")

                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(50)),
                    contentAlignment = Alignment.Center

                ){
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = painterResource(id = R.drawable.mariana_placeholder),
                        contentDescription = "Mariana´s face"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "\uD83D\uDC4B Hola ${firstName?.capitalize(Locale.ROOT)} ${lastName?.capitalize(Locale.ROOT)}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )

                Spacer(modifier = Modifier.height(24.dp))

                CardOptionList(
                    items = listOf(
                        CardOptionData(
                            title = "Mis Datos",
                            onClick = {}
                        ),
                        CardOptionData(
                            title = "Mi CVU",
                            onClick = {}
                        ),
                        CardOptionData(
                            title = "Configuracion",
                            onClick = {}
                        ),
                        CardOptionData(
                            title = "Ayuda",
                            onClick = {}
                        ),
                        CardOptionData(
                            title = "Terminos y condiciones",
                            onClick = {}
                        )
                        ,
                        CardOptionData(
                            title = "Cerrar sesion",
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    onLogoutClick()
                                }
                            }
                        )
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .border(
                            width = 1.dp,
                            MaterialTheme.colorScheme.outline,
                            MaterialTheme.shapes.medium
                        )
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(vertical = 13.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Dark Mode",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                    )

                    Switch(checked = isDarkMode, onCheckedChange = {themeViewModel.toggleTheme()})
                }
            }
        }
    }
}