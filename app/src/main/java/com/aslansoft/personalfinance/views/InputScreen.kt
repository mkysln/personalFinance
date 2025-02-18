package com.aslansoft.personalfinance.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aslansoft.personalfinance.R

@Composable
fun InputScreen(navController: NavHostController,innerPadding: PaddingValues) {
    var income by remember { mutableStateOf("" ) }
    var expense by remember { mutableStateOf("") }
    var checkState by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally) {
       OutlinedTextField(value = income,
           onValueChange = { incomeValue ->
                income = incomeValue
            },
           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
           label = { Text(stringResource(R.string.income)) },
           colors = OutlinedTextFieldDefaults.colors(
               focusedBorderColor = MaterialTheme.colorScheme.secondary,
               focusedLabelColor = MaterialTheme.colorScheme.secondary,
               selectionColors = TextSelectionColors(handleColor = MaterialTheme.colorScheme.secondary, backgroundColor = MaterialTheme.colorScheme.onSecondary)
           ))
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    OutlinedTextField(value = expense,
           onValueChange = { expenseValue ->
                expense= expenseValue
            },
           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
           label = { Text(stringResource(R.string.expense)) })
        Spacer(Modifier.padding(vertical = 7.dp))
        ElevatedButton(onClick = {}) {
            Text(stringResource(R.string.calculate))
        }
        Spacer(Modifier.padding(vertical = 5.dp))
        FilledTonalButton(onClick = {}) {
            Text(stringResource(R.string.save))
        }
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(stringResource(R.string.auto_save), fontSize = 15.sp)
            Checkbox(checked = checkState, onCheckedChange = {
                checkState = it
            })
        }
    }

    BackHandler (true){
        navController.popBackStack()
    }
}