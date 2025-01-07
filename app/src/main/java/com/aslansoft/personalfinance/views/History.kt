package com.aslansoft.personalfinance.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun History(navController: NavHostController, innerPadding: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize().padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn {
            item { Column {
                Box(modifier = Modifier.fillMaxWidth().height(60.dp)) {
                    Box(Modifier.fillMaxWidth().fillMaxHeight(),contentAlignment = Alignment.CenterEnd){
                        Row {
                            Text("Tarih:")
                            Text("21.10.2025")
                        }

                    }
                    Box(Modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.CenterStart){
                        Text("Hisse Senetleri", fontWeight = FontWeight.Bold)
                    }
                }
                HorizontalDivider(Modifier.fillMaxWidth(),1.dp,MaterialTheme.colorScheme.primary)
            }
            }
            item { Column {
                Box(modifier = Modifier.fillMaxWidth().height(60.dp)) {
                    Box(Modifier.fillMaxWidth().fillMaxHeight(),contentAlignment = Alignment.CenterEnd){
                        Row {
                            Text("Tarih:")
                            Text("23.12.2025")
                        }

                    }
                    Box(Modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.CenterStart){
                        Text("Borç ödeme zamanı", fontWeight = FontWeight.Bold)
                    }
                }


                HorizontalDivider(Modifier.fillMaxWidth(),1.dp,MaterialTheme.colorScheme.primary)
            }


            }
            item { Column {
                Box(modifier = Modifier.fillMaxWidth().height(60.dp)) {
                    Box(Modifier.fillMaxWidth().fillMaxHeight(),contentAlignment = Alignment.CenterEnd){
                        Row {
                            Text("Tarih:")
                            Text("11.03.2026")
                        }

                    }
                    Box(Modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.CenterStart){
                        Text("Borç ödeme zamanı", fontWeight = FontWeight.Bold)
                    }
                }


                HorizontalDivider(Modifier.fillMaxWidth(),1.dp,MaterialTheme.colorScheme.primary)
            }


            }
        }
    }
    BackHandler (true){
        navController.popBackStack()
    }
}