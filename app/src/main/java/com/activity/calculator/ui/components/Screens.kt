package com.activity.calculator.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.activity.calculator.ui.theme.CalculatorTheme
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun CalculatorScreen(modifier: Modifier = Modifier) {
    var firstNum by remember { mutableStateOf("") }
    var secondNum by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }
    var operation by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = firstNum,
            onValueChange = { firstNum = it },
            label = { Text("First Number") },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = secondNum,
            onValueChange = { secondNum = it },
            label = { Text("Second Number") },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
        operationDropDown()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = result,
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement= Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    modifier = Modifier.width(175.dp),
                    onClick = {

                    }) {
                    Text("Calculate")
                }
                Button(
                    modifier = Modifier.width(175.dp),
                    onClick = {
                        firstNum = ""
                        secondNum = ""
                    }) {
                    Text("Reset")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        CalculatorScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun operationDropDown() {
    val context = LocalContext.current
    val operations = arrayOf("Addition", "Subtraction", "Multiplication", "Division")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Operation") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                operations.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}