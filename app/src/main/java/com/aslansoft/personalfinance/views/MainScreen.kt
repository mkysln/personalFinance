package com.aslansoft.personalfinance.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aslansoft.calendarLibrary.Calendar
import com.aslansoft.personalfinance.R
import com.aslansoft.personalfinance.fonts.josefinSans
import java.time.LocalDate

@Composable
fun MainScreen(paddingValues: PaddingValues, navController: NavHostController) {
    var menu by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.25f),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.primary,
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 30.dp
                )
            ) {
                Row {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.65f)
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .padding(30.dp),
                                text = "Example BANK",
                                fontSize = 26.5.sp,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                "4444-4444-4444-4444",
                                Modifier
                                    .align(Alignment.Center)
                                    .padding(top = 10.dp)
                            )
                        }


                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top = 60.dp)
                                    .align(Alignment.Center),
                                text = "05/31",
                                color = MaterialTheme.colorScheme.primary
                            )
                            Image(
                                painter = painterResource(R.drawable.card_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .size(50.dp)
                            )
                        }
                    }

                }

            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp)
            ) {
                Column {
                    Text(
                        stringResource(R.string.balance),
                        Modifier.align(Alignment.Start),
                        fontSize = 30.sp,
                        fontFamily = josefinSans
                    )
                    Text("0" + stringResource(R.string.currency), Modifier.align(Alignment.Start), fontSize = 25.sp)

                }
                Box(modifier = Modifier.weight(1f)) {
                    IconButton(onClick = {
                        menu = !menu
                    }, modifier = Modifier.align(Alignment.CenterEnd)) {

                        androidx.compose.animation.AnimatedVisibility(
                            visible = menu,
                            enter = expandHorizontally(),
                            exit = shrinkHorizontally()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        androidx.compose.animation.AnimatedVisibility(
                            visible = !menu,
                            enter = expandHorizontally(),
                            exit = shrinkHorizontally()
                        ) {
                            Icon(
                                imageVector = Icons.Sharp.Menu,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }


                    }


                }
            }

            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            HorizontalDivider(
                thickness = 0.5.dp, color = MaterialTheme.colorScheme.secondary
            )
            AnimatedVisibility(
                visible = menu,
                enter = expandVertically(expandFrom = Alignment.Top),
                exit = shrinkVertically(shrinkTowards = Alignment.Bottom)
            ) {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 4.dp)
                                .clickable { navController.navigate("pay_reminder") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text(
                                stringResource(R.string.pay_reminder),
                                Modifier.align(Alignment.CenterVertically),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 4.dp)
                                .clickable { navController.navigate("history") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text(
                                stringResource(R.string.history),
                                Modifier.align(Alignment.CenterVertically),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )


                        }
                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 4.dp)
                                .clickable { navController.navigate("calculator") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text(
                                stringResource(R.string.calculations),
                                Modifier.align(Alignment.CenterVertically),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )


                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 4.dp)
                                .clickable { navController.navigate("account") },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountBox,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text(
                                stringResource(R.string.my_account),
                                Modifier.align(Alignment.CenterVertically),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 4.dp)
                                .clickable { /*TODO*/ },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text(
                                stringResource(R.string.feedback),
                                Modifier.align(Alignment.CenterVertically),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(start = 4.dp)
                                .clickable { /*TODO*/ },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                contentDescription = null,
                                modifier = Modifier.size(28.dp),
                                tint = Color.Red
                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Text(
                               stringResource( R.string.sign_out),
                                Modifier.align(Alignment.CenterVertically),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontStyle = FontStyle.Italic,
                                color = Color.Red
                            )
                        }

                    }
                    item {
                        HorizontalDivider()
                    }
                }
            }
            if (!menu) {
                val markedDays = listOf(
                    LocalDate.now()
                )
                Spacer(Modifier.padding(vertical = 5.dp))
                Calendar(
                    modifier = Modifier
                        .border(
                            width = 0.5.dp,
                            color = MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .clip(
                            RoundedCornerShape(15.dp)
                        ),
                    markedDays = markedDays,
                    containerColor = MaterialTheme.colorScheme.background,
                    headerColor = MaterialTheme.colorScheme.tertiary,
                    currentDaysBorderColor = MaterialTheme.colorScheme.secondary,
                    todayBorderColor = MaterialTheme.colorScheme.primary,
                    todayTextColor = MaterialTheme.colorScheme.primary,
                    selectedDayBorderColor = MaterialTheme.colorScheme.secondary,

                )
            }
        }
    }
}


