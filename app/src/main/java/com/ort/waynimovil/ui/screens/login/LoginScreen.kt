package com.ort.waynimovil.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ort.waynimovil.navigation.Routes
import com.ort.waynimovil.ui.components.ChatBubble

import com.ort.waynimovil.R
import com.ort.waynimovil.ui.components.CustomButton
import com.ort.waynimovil.ui.components.TextButton
import com.ort.waynimovil.ui.screens.UserViewModel


//Username: donero - Password: ewedon
@Composable
fun LoginScreen(
    navController: NavHostController,
    userViewModel: UserViewModel,
    onSuccessLogin: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()

    val userDataFetched by userViewModel.userDataFetched.collectAsState()

    LaunchedEffect(userDataFetched) {
        if (userDataFetched) {
            onSuccessLogin()
            navController.navigate(Routes.HOME) {
                popUpTo(Routes.LOGIN) { inclusive = true }
            }
        }
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        LogoSection()

        Card(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomCenter),
            colors = CardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            )
        ) {

            when (loginState) {
                is LoginState.Idle, is LoginState.Error -> {
                    if (loginState is LoginState.Error) {
                        val errorMessage = "Credenciales invalidas"
                        LaunchedEffect(errorMessage) {
                            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                            viewModel.resetState()
                        }
                    }
                    LoginForm(
                        onLogin = { username, password ->
                            viewModel.login(username, password)
                        }
                    )
                }
                is LoginState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is LoginState.Success -> {
                    LaunchedEffect(Unit) {
                        // Guardo el token, y busco la info del usuario
                        userViewModel.setLoginToken((loginState as LoginState.Success).token)
                        userViewModel.fetchUserData(1)
                    }
                }
            }

        }
    }
}

@Composable
fun LoginForm(onLogin: (String, String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
    ) {
        Text("Ingresá a tu cuenta:", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("DNI o E-mail") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier.align(Alignment.End)
        ) {
            TextButton(text = "Olvide mi contraseña", onClick = { /*TODO*/ }, textStyle = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text("Recordar datos de ingreso")
        }
        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(text = "Ingresar", onClick = { onLogin(username, password) })
    }
}

@Composable
fun LogoSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo_waynimovil),
            contentDescription = "Waynimovil Logo",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(25.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.Start
            ) {
                RoundedTriangle()
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                ) {
                    ChatBubble(
                        text = "UNA BILLETERA",
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    ChatBubble(
                        text = "😊",
                        backgroundColor = MaterialTheme.colorScheme.tertiary
                    )
                }
                Spacer(modifier = Modifier.height(4.5.dp))
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    ChatBubble(
                        text = "\uD83D\uDE4C",
                        backgroundColor = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    ChatBubble(
                        text = "SIMPLE PARA VOS.",
                    )
                }
            }
        }
    }
}

//Ni preguntes como funciona esto.
@Composable
fun RoundedTriangle() {
    Canvas(modifier = Modifier
        .size(24.dp)
        .offset(y = 3.dp, x = 30.dp)
    ) {
        // Crea un cuadradro con el tamaño del canvas, y mueve una linieta estilo la tortuga de LOGO
        val rect = Rect(Offset.Zero, size)
        val trianglePath = Path().apply {
            moveTo(rect.topCenter)
            lineTo(rect.bottomRight)
            lineTo(rect.bottomLeft)
            close()
        }

        drawIntoCanvas { canvas ->
            canvas.drawOutline(
                outline = Outline.Generic(trianglePath),
                paint = Paint().apply {
                    color = Color(0xFFDAE9FC)
                    pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 4)
                }
            )
        }
    }
}
fun Path.moveTo(offset: Offset) = moveTo(offset.x, offset.y)
fun Path.lineTo(offset: Offset) = lineTo(offset.x, offset.y)