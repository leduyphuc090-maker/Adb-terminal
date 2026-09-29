package com.leduyphuc.adbterminal.ui

import android.content.Context
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
import com.leduyphuc.adbterminal.util.DeviceInfo

@Composable
fun HomeScreen(context: Context, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Thông tin thiết bị", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        InfoCard("Thiết bị", DeviceInfo.model())
        InfoCard("Hệ điều hành", DeviceInfo.androidVersion())
        InfoCard("Độ phân giải", DeviceInfo.resolution(context))
        InfoCard("Mật độ điểm ảnh", DeviceInfo.density(context))
        InfoCard("Tần số quét", DeviceInfo.refreshRate(context))
        InfoCard("CPU", DeviceInfo.cpuCores())
        InfoCard("RAM", DeviceInfo.ramInfo(context))
        InfoCard("Vulkan", if (DeviceInfo.supportsVulkan()) "Hỗ trợ" else "Không hỗ trợ")
        InfoCard("USB OTG", if (DeviceInfo.hasMouse(context)) "Có" else "Không")
    }
}

@Composable
fun InfoCard(label: String, value: String) {
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
            Text(label, color = Color.Gray)
            Text(
                value,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}