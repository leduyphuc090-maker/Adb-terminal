package com.leduyphuc.adbterminal.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TouchScreen(context: Context, modifier: Modifier = Modifier) {
    var sensitivity by remember { mutableStateOf(0.5f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text("Cảm ứng & Chuột", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Độ nhạy cảm ứng (trong app)", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(12.dp))
                Slider(value = sensitivity, onValueChange = { sensitivity = it })
                Text("%.0f%%".format(sensitivity * 100), color = Color.Gray)
                Spacer(Modifier.height(8.dp))
                Text(
                    "Độ nhạy toàn hệ thống cần root.",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Chuột vật lý", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(
                    "Chỉnh con trỏ chuột cần root (sửa file idc).",
                    color = Color(0xFFFF9800),
                    fontSize = 13.sp
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Chuột Bluetooth", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(
                    "Kết nối qua Cài đặt hệ thống > Bluetooth.",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
    }
}