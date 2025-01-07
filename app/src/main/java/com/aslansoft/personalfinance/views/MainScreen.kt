package com.aslansoft.personalfinance.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aslansoft.personalfinance.R
import com.aslansoft.personalfinance.fonts.josefinSans
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(paddingValues: PaddingValues, navController: NavHostController) {
    var menu by remember { mutableStateOf(false) }
    val datePickerState = DatePickerState(locale = Locale.getDefault(), initialDisplayMode = DisplayMode.Picker)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally){
            ElevatedCard(modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.25f), colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.primary,
            ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 30.dp
                )) {
                Row (){
                    Row(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.65f)) {
                        Box(modifier = Modifier.fillMaxSize()){
                            Text(modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(30.dp),text = "Example BANK", fontSize = 26.5.sp, fontWeight = FontWeight.Light,fontStyle = FontStyle.Italic)
                            Text("4444-4444-4444-4444",
                                Modifier
                                    .align(Alignment.Center)
                                    .padding(top = 10.dp))
                        }



                    }
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)) {
                            Text(modifier = Modifier
                                .padding(top = 60.dp)
                                .align(Alignment.Center), text = "05/31", color = MaterialTheme.colorScheme.primary)
                            Image(painter = painterResource(R.drawable.card_icon), contentDescription = null, modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(50.dp))
                        }
                    }

                }

            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 3.dp)) {
                Column() {
                    Text("Kalan:",Modifier.align(Alignment.Start), fontSize = 30.sp, fontFamily = josefinSans)
                    Text("0₺",Modifier.align(Alignment.Start), fontSize = 25.sp)

                }
                Box(modifier = Modifier.weight(1f)){
                    IconButton(onClick = {
                        menu = !menu
                    }, modifier = Modifier.align(Alignment.CenterEnd)) {

                                  androidx.compose.animation.AnimatedVisibility(visible = menu, enter = expandHorizontally(), exit = shrinkHorizontally()) {
                                      Icon(imageVector = Icons.Default.Home, contentDescription = "", tint = MaterialTheme.colorScheme.primary)
                                  }
                        androidx.compose.animation.AnimatedVisibility(visible = !menu, enter = expandHorizontally(), exit = shrinkHorizontally()) {
                            Icon(imageVector = Icons.Sharp.Menu, contentDescription = "", tint = MaterialTheme.colorScheme.primary)
                        }








                            }


                    }
                }

            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            AnimatedVisibility(visible = menu, enter = expandVertically(expandFrom = Alignment.Top), exit = shrinkVertically(shrinkTowards = Alignment.Bottom)) {
                LazyColumn(modifier = Modifier.weight(1f)){
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 4.dp)
                            .clickable { navController.navigate("pay_reminder") }, verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = null, modifier = Modifier.size(30.dp))
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text("Ödeme Hatırlatıcı",Modifier.align(Alignment.CenterVertically), fontSize = 20.sp, fontWeight = FontWeight.Medium)


                        }
                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 4.dp)
                            .clickable { navController.navigate("history") }, verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.DateRange, contentDescription = null, modifier = Modifier.size(30.dp))
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text("Geçmiş",Modifier.align(Alignment.CenterVertically), fontSize = 20.sp, fontWeight = FontWeight.Medium)


                        }
                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 4.dp)
                            .clickable {navController.navigate("calculator")}, verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = null, modifier = Modifier.size(30.dp))
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text("Hesaplamalar",Modifier.align(Alignment.CenterVertically), fontSize = 20.sp, fontWeight = FontWeight.Medium)


                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 4.dp)
                            .clickable { navController.navigate("account") }, verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null, modifier = Modifier.size(30.dp))
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text("Hesabım",Modifier.align(Alignment.CenterVertically), fontSize = 20.sp, fontWeight = FontWeight.Medium)
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 4.dp)
                            .clickable { /*TODO*/ }, verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Warning, contentDescription = null, modifier = Modifier.size(30.dp))
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text("Geri Bildirim",Modifier.align(Alignment.CenterVertically), fontSize = 20.sp, fontWeight = FontWeight.Medium)
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item{
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 4.dp)
                            .clickable { /*TODO*/ }, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null, modifier = Modifier.size(28.dp), tint = Color.Red)
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text("Çıkış Yap",Modifier.align(Alignment.CenterVertically), fontSize = 17.sp, fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Italic, color = Color.Red)
                        }

                    }
                    item {
                        HorizontalDivider()
                    }
                }
            }
            if (!menu){
                DatePicker(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),state = datePickerState,
                    headline = {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text("Ödeme Takvimi", textAlign = TextAlign.Center, fontSize = 15.sp, fontWeight = FontWeight.Bold, fontFamily = josefinSans)
                        }

                    },
                    title = null,
                    showModeToggle = false,
                    colors = DatePickerDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        dayContentColor = MaterialTheme.colorScheme.primary,
                        todayDateBorderColor = MaterialTheme.colorScheme.secondary,
                        todayContentColor = MaterialTheme.colorScheme.secondary,
                        selectedDayContentColor = MaterialTheme.colorScheme.background,
                        selectedDayContainerColor = MaterialTheme.colorScheme.secondary,
                        yearContentColor = MaterialTheme.colorScheme.primary,
                        selectedYearContentColor = MaterialTheme.colorScheme.background,
                        currentYearContentColor = MaterialTheme.colorScheme.secondary,
                        selectedYearContainerColor = MaterialTheme.colorScheme.secondary,
                        weekdayContentColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
            }
        }
    }


