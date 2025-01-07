package com.aslansoft.personalfinance

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aslansoft.personalfinance.ui.theme.PersonalFinanceTheme
import com.aslansoft.personalfinance.views.Account
import com.aslansoft.personalfinance.views.Calculator
import com.aslansoft.personalfinance.views.History
import com.aslansoft.personalfinance.views.InputScreen
import com.aslansoft.personalfinance.views.MainScreen
import com.aslansoft.personalfinance.views.PayReminder
import com.google.accompanist.systemuicontroller.rememberSystemUiController



@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUIController = rememberSystemUiController()
            if(isSystemInDarkTheme()) systemUIController.setStatusBarColor(Color.Black) else systemUIController.setStatusBarColor(Color.White)
            if(isSystemInDarkTheme()) systemUIController.setNavigationBarColor(Color.Black) else systemUIController.setNavigationBarColor(Color.White)
            PersonalFinanceTheme {
                val navController = rememberNavController()
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                       AnimatedVisibility(visible = currentRoute != "input_screen", enter = expandIn(),
                           exit = shrinkOut()
                       ) {
                           CenterAlignedTopAppBar( title = { Text("My Finance") },
                               colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                   containerColor = MaterialTheme.colorScheme.tertiary)
                           )
                       }


                         },
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {

                        AnimatedVisibility(visible = currentRoute == "main_screen", enter = expandHorizontally(expandFrom = Alignment.End), exit = shrinkHorizontally(shrinkTowards = Alignment.End)) {
                            FloatingActionButton(onClick = {

                            navController.navigate("input_screen")
                            }) {
                                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                            }
                        }

                }) { innerPadding ->

                    NavHost(navController = navController , startDestination = "main_screen"){
                        composable(route = "main_screen") {
                            MainScreen(paddingValues = innerPadding, navController = navController)
                        }
                        composable(route = "input_screen", enterTransition = { expandVertically() }, exitTransition = { shrinkVertically() }) {
                            InputScreen(navController = navController, innerPadding = innerPadding)
                        }
                        composable(route = "pay_reminder", enterTransition = {
                            expandHorizontally()
                        }, exitTransition = { shrinkHorizontally() }) {
                            PayReminder(innerPadding = innerPadding,navController = navController)
                        }
                        composable(route = "history", enterTransition = {
                            expandHorizontally()
                        }, exitTransition = { shrinkHorizontally() }) {
                            History(innerPadding = innerPadding,navController = navController )
                        }
                        composable(route = "account", enterTransition = {
                            expandHorizontally()
                        }, exitTransition = { shrinkHorizontally() }) {
                            Account(innerPadding = innerPadding,navController = navController )
                        }
                        composable(route = "calculator", enterTransition = {
                            expandHorizontally()
                        }, exitTransition = { shrinkHorizontally() }) {
                            Calculator(innerPadding = innerPadding, navController = navController)
                        }
                    }

                }
            }
        }
    }
}

