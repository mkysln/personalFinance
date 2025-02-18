package com.aslansoft.personalfinance.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aslansoft.personalfinance.R
import com.aslansoft.personalfinance.fonts.josefinSans

@Composable
fun Account(navController: NavHostController, innerPadding: PaddingValues) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f), contentAlignment = Alignment.Center){
            Icon(modifier = Modifier.fillMaxSize(0.8f),imageVector = Icons.Default.AccountCircle, contentDescription = "")
        }
        Row(modifier = Modifier.fillMaxWidth().height(70.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            HorizontalDivider(modifier = Modifier.weight(1f).padding(start = 3.dp), color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.padding(horizontal = 3.dp))
            Text("name", fontSize = 30.sp)
            Spacer(Modifier.padding(horizontal = 3.dp))
            HorizontalDivider(modifier = Modifier.weight(1f).padding(end = 3.dp), color = MaterialTheme.colorScheme.primary)
        }
        Spacer(Modifier.padding(vertical = 10.dp))
        Text("Username")
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.8f).height(40.dp), elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        )) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                BasicTextField(modifier = Modifier.fillMaxSize(),value = username, onValueChange = {
                    username = it
                }, textStyle = TextStyle.Default.copy(fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary), cursorBrush = SolidColor(Color.Unspecified))
            }

        }
        Text("Email")
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.8f).height(40.dp), elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        )) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                BasicTextField(modifier = Modifier.fillMaxSize(),value = email, onValueChange = {
                    email = it
                }, textStyle = TextStyle.Default.copy(fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary), cursorBrush = SolidColor(Color.Unspecified))
            }

        }
        Text("Password")
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.8f).height(40.dp), elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        )) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                BasicTextField(modifier = Modifier.fillMaxSize(),value = password, onValueChange = {
                    password = it
                }, textStyle = TextStyle.Default.copy(fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary), cursorBrush = SolidColor(Color.Unspecified),
                    visualTransformation = PasswordVisualTransformation())
            }

        }
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.8f).height(40.dp).clickable {  }, elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 7.dp
        )) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                    Text( text = stringResource(R.string.update), fontFamily = josefinSans, fontWeight = FontWeight.Bold, fontSize = 18.5.sp)

            }

        }
    }
    BackHandler(true) {
        navController.popBackStack()
    }
}