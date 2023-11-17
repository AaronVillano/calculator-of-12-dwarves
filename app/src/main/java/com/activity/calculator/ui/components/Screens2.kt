package com.activity.calculator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Slider
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import kotlin.random.Random
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Preview
@Composable
public fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(50f) }
    var randomValue by remember { mutableStateOf(0) }

    fun reset() {
        sliderPosition = 50f // default slider value
        randomValue = 0 // default value of the generated number
    }

    Column(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween, // Place buttons at the bottom
        horizontalAlignment = Alignment.CenterHorizontally // Center-align generated number
    ) {
        Text(text = sliderPosition.toInt().toString())
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f
        )
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${randomValue}",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 50.sp,
                textAlign = TextAlign.Center // Center-align the generated number

            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement= Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    modifier = Modifier.width(175.dp),
                    onClick = { randomValue = Random.nextInt(0, sliderPosition.toInt() + 1) }) {
                    Text("Generate")
                }
                Button(
                    modifier = Modifier.width(175.dp),
                    onClick = { reset() }) {
                    Text("Reset")
                }
            }
        }
    }
}