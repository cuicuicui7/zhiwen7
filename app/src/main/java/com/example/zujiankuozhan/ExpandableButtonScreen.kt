package com.example.zujiankuozhan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableButtonScreen() {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 输入框和加号按钮
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.White, shape = MaterialTheme.shapes.small),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .padding(1.dp)
                        .background(
                            Color.Black,
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .size(22.dp)
                            .padding(1.5.dp)
                            .pointerInput(Unit) {
                                detectTapGestures { isExpanded=!isExpanded }
                            }
                            .background(Color.White, shape = MaterialTheme.shapes.small),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Expand",
                            tint = Color.Black
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = "请输入文字",
                onValueChange = { },
                label = { Text("请输入文字") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .weight(1f)
            )
        }

        // 可扩展的界面
        if (isExpanded) {
            Surface(
                modifier = Modifier
                    .width(375.dp)
                    .height(44.dp)
                    .padding(top = 8.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {}) {
                        Text("新建对话")
                    }
                    Button(onClick = { /* 历史记录逻辑 */ }) {
                        Text("历史记录")
                    }
                    Button(onClick = { /* 收藏夹逻辑 */ }) {
                        Text("收藏夹")
                    }
                    Button(onClick = { /* 个性化练习逻辑 */ }) {
                        Text("个性化练习")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpandableButtonScreen()
}