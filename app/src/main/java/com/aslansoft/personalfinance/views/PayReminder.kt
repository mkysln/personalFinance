package com.aslansoft.personalfinance.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Badge
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aslansoft.personalfinance.R
import com.aslansoft.personalfinance.fonts.josefinSans

@Composable
fun PayReminder(innerPadding: PaddingValues, navController: NavHostController) {

    var reminderNote by remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val maxChar = 8
        val error = remember { mutableStateOf(false) }
        ElevatedCard(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(
                bottomEnd = 0.dp, bottomStart = 0.dp, topStart = 15.dp, topEnd = 15.dp
            )
        ) {
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(8) {
                    Badge(containerColor = Color.Black, modifier = Modifier.size(15.dp))
                }
            }
        }
        ElevatedCard(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(0.dp)) {
            Column {
                Spacer(Modifier.padding(vertical = 10.dp))
                HorizontalDivider()
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) { Text(stringResource(R.string.date), fontSize = 20.sp) }

                HorizontalDivider()
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = date.value,
                    onValueChange = {
                        if (it.length <= maxChar) {
                            date.value = it
                        }
                        if (date.value.isNotEmpty() && date.value.length >= 8) {
                            val day = date.value.substring(0, 2).toIntOrNull()
                            val month = date.value.substring(2, 4).toIntOrNull()
                            if (day != null && month != null) {
                                error.value = !(day in 1..31 && month in 1..12)
                            } else {
                                error.value = false
                            }
                            if (date.value.isEmpty()) {
                                error.value = true
                            }
                        }
                    },
                    visualTransformation = DateTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
                )
                HorizontalDivider()
                Spacer(Modifier.padding(vertical = 2.dp))
                if (error.value) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "*" + stringResource(R.string.date_warning),
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.error
                        )
                    }

                    HorizontalDivider()
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        stringResource(R.string.reminder),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )

                }
                HorizontalDivider()
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(), value = reminderNote, onValueChange = {
                        reminderNote = it
                    }, singleLine = true, textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ), cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
                )

                HorizontalDivider()
                Spacer(Modifier.padding(vertical = 10.dp))
            }

        }
        ElevatedCard(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(
                bottomEnd = 15.dp, bottomStart = 15.dp, topStart = 0.dp, topEnd = 0.dp
            )
        ) {}

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        ElevatedButton(onClick = {}) {
            Text(
                stringResource(R.string.save), fontFamily = josefinSans, fontSize = 20.sp
            )
        }
    }


    BackHandler(true) {
        navController.popBackStack()
    }
}

class DateTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return dateFilter(text)
    }
}

fun dateFilter(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 2 == 1 && i < 4) out += "/"
    }
    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 3) return offset + 1
            if (offset <= 8) return offset + 2
            return 10
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset - 1
            if (offset <= 10) return offset - 2
            return 8
        }
    }
    return TransformedText(AnnotatedString(out), numberOffsetTranslator)

}

