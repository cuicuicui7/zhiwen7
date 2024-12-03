package com.example.zujiankuozhan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpandableButtonScreen01() {
    var isExpanded by remember { mutableStateOf(false) } // 正确使用 mutableStateOf

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ExpandableButton01(isExpanded) { isExpanded = !isExpanded }
        if (isExpanded) {
            ExpandedScreen01()
        }
    }
}

@Composable
fun ExpandableButton01(isExpanded:Boolean,onToggle:()->Unit) {
    Button(
        onClick = onToggle,
        modifier = Modifier.fillMaxWidth().height(50.dp)
    ) {
        Text(text = if (isExpanded) "Close" else "Expand", fontSize = 18.sp)
    }
}

@Composable
fun ExpandedScreen01(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "课程名字", fontSize = 24.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "X月X日 XX:XX", fontSize = 18.sp, modifier = Modifier.padding(bottom = 16.dp))
    }
}