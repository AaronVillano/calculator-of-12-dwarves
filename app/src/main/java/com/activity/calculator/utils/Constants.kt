package com.activity.calculator.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import com.activity.calculator.models.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Calculator",
            icon = Icons.Default.Home,
            route = "calculator"
        ),
        BottomNavItem(
            label = "Number Generator",
            icon = Icons.Default.Person,
            route = "numgen"
        )
    )
}