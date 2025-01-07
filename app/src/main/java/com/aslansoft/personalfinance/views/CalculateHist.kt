package com.aslansoft.personalfinance.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Calculator(innerPadding: PaddingValues, navController: NavHostController) {
    Column (modifier = Modifier.fillMaxSize().padding(innerPadding)){
        Text("hesapla")
    }
}