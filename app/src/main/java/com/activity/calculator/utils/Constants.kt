package com.activity.calculator.utils

import com.activity.calculator.models.BottomNavItem
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

object Constants {
    val calculateIcon: ImageVector = painterResource(id = R.drawable.ic_custom_calculate)
    val genIcon: ImageVector = painterResource(id = R.drawable.ic_custom_numgen)
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Calculator",
            icon = calculateIcon,
            route = "calculator"
        ),
        BottomNavItem(
            label = "Number Generator",
            icon = genIcon,
            route = "numgen"
        )
    )
}