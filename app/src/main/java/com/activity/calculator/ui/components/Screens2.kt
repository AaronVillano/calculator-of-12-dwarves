package com.activity.calculator.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Slider
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import kotlin.random.Random

@Preview
@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(50f) }
    var randomValue by remember { mutableStateOf(0) }

    fun reset() {
        sliderPosition = 50f // default slider value
        randomValue = 0 // default value of the generated value
    }
    Column (modifier = Modifier.padding(horizontal = 10.dp)){
        Text(text = sliderPosition.toInt().toString())
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f
        )
        // generate random number within the selected range
        val minValue = 0
        val maxValue = sliderPosition.toInt()

        Button(onClick = { randomValue = Random.nextInt(minValue, maxValue + 1) }) {
            Text("Generate")
        }
        Text("${randomValue}")

        Button(onClick = { reset() }) {
            Text("Reset")
        }
    }
}