package com.example.zujiankuozhan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableButtonScreen02() {
    var innerSize by remember { mutableStateOf(24.dp) }

    Layout(
        modifier = Modifier
            .size(24.dp)
            .clickable { },
        content = {
            Box(
                modifier = Modifier
                    .size(innerSize)
                    .background(Color.Black, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Expand",
                    tint = Color.White,
                    modifier = Modifier
                        .size(18.dp) // Adjust the size to fit within the inner black box
                )
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val width = placeables.maxByOrNull { it.width }?.width ?: 0
        val height = placeables.maxByOrNull { it.height }?.height ?: 0
        layout(width, height) {
            placeables.forEach { it.place(0, 0) }
        }
    }


}
