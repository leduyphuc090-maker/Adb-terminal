package com.leduyphuc.adbterminal.ui

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
fun GraphicsScreen(modifier: Modifier = Modifier) {
    var animationOn by remember { mutableStateOf(true) }
    var roundedCorners by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text("Đồ họa & Giao diện", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        SettingSwitch(
            title = "Hiệu ứng chuyển động",
            subtitle = "Bật/tắt animation trong app",
            value = animationOn,
            onValueChange = { animationOn = it }
        )

        SettingSwitch(
            title = "Bo tròn góc",
            subtitle = "Thiết kế hiện đại",
            value = roundedCorners,
            onValueChange = { roundedCorners = it }
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Bật Vulkan toàn hệ thống", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(
                    "Cần root. Không khả dụng trên máy chưa root.",
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
                Text("Đổi độ phân giải", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(
                    "Cần quyền ADB/Shizuku. Sẽ có trong bản cập nhật sau.",
                    color = Color(0xFFFF9800),
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
fun SettingSwitch(
    title: String,
    subtitle: String,
    value: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.SemiBold)
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
            Switch(checked = value, onCheckedChange = onValueChange)
        }
    }
}