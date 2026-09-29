package com.leduyphuc.adbterminal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Cài đặt & Giới thiệu", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        InfoCard("Tên app", "Device Tuner")
        InfoCard("Phiên bản", "2.0")
        InfoCard("Tác giả", "Lê Duy Phúc")
        InfoCard("License", "MIT")

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Ghi chú", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(
                    "Một số chức năng cần quyền root hoặc ADB. App sẽ hiển thị cảnh báo thay vì thực hiện.",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
    }
}