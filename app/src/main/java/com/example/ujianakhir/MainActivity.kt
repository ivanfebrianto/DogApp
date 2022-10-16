package com.example.ujianakhir

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ujianakhir.data.model.Puppy
import com.example.ujianakhir.ui.theme.BarkHomeContent
import com.example.ujianakhir.ui.theme.UjianakhirTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {
    companion object{
        val TAG :String = MainActivity::class.java.simpleName
    }

    private val auth by lazy{
        Firebase.auth
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            UjianakhirTheme {
               // LoginScreen(auth)
                MyApp{
                    startActivity(ProfileActivity.newIntent(this,it))
                }
            }
        }
    }
}
@Composable
fun MyApp(navigationProfile: (Puppy)->Unit){
    Scaffold(
        content = {
            BarkHomeContent(navigateToProfile = navigationProfile )
    })
}

@Composable
fun LoginScreen(auth: FirebaseAuth){


    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf {
        password.length>6
    }

    var isPasswordVisiblie by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Welcome ...",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_danish_flag_heart),
            contentDescription = "Danish Heart Flag",
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "... Velkommen",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(10.dp)
            ) {

                OutlinedTextField(value = email,
                    onValueChange = {email = it},
                    label = { Text(text = "Email Address")},
                    placeholder = { Text(text = "abc@domain.com")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    isError = !isEmailValid,
                    trailingIcon = {
                        if (email.isNotBlank()){
                            IconButton(onClick = {email = ""}) {
                                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear email")
                            }
                        }
                    }
                )
                OutlinedTextField(value = password,
                    onValueChange = {password = it},
                    label = { Text(text = "password")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus()}
                    ),
                    isError = !isPasswordValid,
                    trailingIcon = {
                        IconButton(
                            onClick = { isPasswordVisiblie = !isPasswordVisiblie}) {
                            Icon(imageVector = if(isPasswordVisiblie) Icons.Default.Visibility else Icons.Default.VisibilityOff, contentDescription = "Toggle password visibility")
                        }
                    },
                    visualTransformation = if(isPasswordVisiblie) VisualTransformation.None else PasswordVisualTransformation()
                )
                val context = LocalContext.current
                Button(
                    onClick = {
                        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                            if(it.isSuccessful){
                                Log.d(ContentValues.TAG,"The user has successfully logged in")
                                    //context.startActivity(Intent(context, BarkHomeContent()::class.java))
                            }else{
                                Log.d(ContentValues.TAG,"The user has FAILED to log in",it.exception)
                            }

                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                    enabled = isEmailValid && isPasswordValid
                ) {
                    Text(
                        text = "Log in",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    text = "Forgot your password?",
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Button(
            onClick = { /*TODO*/ },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 16.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UjianakhirTheme {
       LoginScreen(Firebase.auth)
    }
}