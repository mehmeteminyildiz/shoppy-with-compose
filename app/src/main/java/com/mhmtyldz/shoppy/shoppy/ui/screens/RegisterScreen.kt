package com.mhmtyldz.shoppy.shoppy.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import timber.log.Timber

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun RegisterScreen(
    navController: NavController,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        HalfScreenCardView(modifier = Modifier.align(Alignment.BottomCenter)) {
            RegisterUI(navController)
        }
    }
}


@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.s_black), colorResource(id = R.color.s_gradient_1)
    )
}

@Composable
private fun RegisterUI(navController: NavController) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val passwordAgainState = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.defaultMinSize(minHeight = 500.dp)
    ) {

        SignUpText()
        Spacer(modifier = Modifier.padding(top = 32.dp))
        EmailField(emailState.value) { newValue ->
            emailState.value = newValue
        }
        PasswordField(passwordState.value) { newValue ->
            passwordState.value = newValue
        }
        PasswordAgainField(passwordAgainState.value) { newValue ->
            passwordAgainState.value = newValue
        }

        SignUpButton(navController, emailState, passwordState, passwordAgainState)
        AlreadyHaveAnAccounText(navController)

    }
}


@Composable
private fun HalfScreenCardView(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        color = Color.White,
        elevation = 4.dp
    ) {
        content()
    }

}

@Composable
private fun SignUpText() {
    Text(
        text = "Sign Up",
        modifier = Modifier.padding(horizontal = 24.dp),
        style = MaterialTheme.typography.h5,
        fontSize = 32.sp
    )
}

@Composable
private fun PasswordAgainField(passwordAgainState: String, function: (String) -> Unit) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth()
            .border(
                BorderStroke(0.dp, Color.Transparent), RoundedCornerShape(8.dp)
            ),
        value = passwordAgainState,
        shape = RoundedCornerShape(8.dp),
        onValueChange = { newText ->
            function(newText)
        },
        placeholder = {
            Text(
                text = "Password Again", color = colorResource(id = R.color.s_hint)
            )
        },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide Password" else "Show Password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = image,
                    contentDescription = description,
                    tint = colorResource(id = R.color.s_black)
                )
            }

        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.s_grey_light),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = colorResource(id = R.color.s_black)
        )
    )
}

@Composable
private fun PasswordField(passwordState: String, function: (String) -> Unit) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth()
            .border(
                BorderStroke(0.dp, Color.Transparent), RoundedCornerShape(8.dp)
            ),
        value = passwordState,
        shape = RoundedCornerShape(8.dp),
        onValueChange = { newText ->
            function(newText)
        },
        placeholder = {
            Text(
                text = "Password", color = colorResource(id = R.color.s_hint)
            )
        },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide Password" else "Show Password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = image,
                    contentDescription = description,
                    tint = colorResource(id = R.color.s_black)
                )
            }

        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.s_grey_light),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = colorResource(id = R.color.s_black)
        )
    )
}

@Composable
private fun EmailField(emailState: String, function: (String) -> Unit) {

    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth()
            .border(
                BorderStroke(0.dp, Color.Transparent), RoundedCornerShape(8.dp)
            ),
        value = emailState,
        shape = RoundedCornerShape(8.dp),
        onValueChange = { newText ->
            function(newText)
        },
        placeholder = {
            Text(
                text = "Email", color = colorResource(id = R.color.s_hint)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.s_grey_light),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = colorResource(id = R.color.s_black)
        )
    )
}

private fun cardClicked(
    navController: NavController,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    passwordAgainState: MutableState<String>
) {
    Timber.e("email : ${emailState.value}")
    Timber.e("password : ${passwordState.value}")
    Timber.e("passwordAgain : ${passwordAgainState.value}")

    val email = emailState.value
    val password = passwordState.value
    val passwordAgain = passwordAgainState.value

    if (email.isNotEmpty() && password.isNotEmpty() && passwordAgain.isNotEmpty() && (password == passwordAgain)) {
        navController.navigate("login_screen") {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    } else {
        Timber.e("Eksik Bilgi Girişi veya parolalar eşleşmiyor")
    }


}


@Composable
private fun SignUpButton(
    navController: NavController,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    passwordAgainState: MutableState<String>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 24.dp)
            .clickable {
                cardClicked(
                    navController = navController,
                    emailState,
                    passwordState,
                    passwordAgainState
                )
            },
        shape = RoundedCornerShape(100),
        backgroundColor = colorResource(id = R.color.s_black)
    ) {
        Text(
            text = "Sign Up",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun gotoLoginPage(navController: NavController) {
    navController.navigate("login_screen") {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}

@Composable
private fun AlreadyHaveAnAccounText(navController: NavController) {
    Text(
        text = "Already have an account? Sign In",
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                gotoLoginPage(navController)
            },
        textAlign = TextAlign.Center,
        fontSize = 16.sp
    )
}

