package com.leduyphuc.adbterminal.ui

import android.content.Context
import android.content.Intent
import android.provider.Settings
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
import com.leduyphuc.adbterminal.util.DeviceInfo

@Composable
fun PerformanceScreen(context: Context, modifier: Modifier = Modifier) {
    var brightness by remember { mutableStateOf(0.5f) }
    var showPermission by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text("Hiệu năng", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Độ sáng màn hình", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(12.dp))
                Slider(
                    value = brightness,
                    onValueChange = { brightness = it },
                    onValueChangeFinished = {
                        try {
                            val resolver = context.contentResolver
                            Settings.System.putInt(
                                resolver,
                                Settings.System.SCREEN_BRIGHTNESS,
                                (brightness * 255).toInt()
                            )
                        } catch (e: Exception) {
                            showPermission = true
                        }
                    }
                )
                Text("%.0f%%".format(brightness * 100), color = Color.Gray)
            }
        }

        InfoCard("RAM", DeviceInfo.ramInfo(context))
        InfoCard("CPU", DeviceInfo.cpuCores())
        InfoCard("Tần số quét", DeviceInfo.refreshRate(context))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Ép xung / Overclock", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(
                    "Cần root. Máy chưa root nên không khả dụng.",
                    color = Color(0xFFFF9800),
                    fontSize = 13.sp
                )
            }
        }
    }

    if (showPermission) {
        AlertDialog(
            onDismissRequest = { showPermission = false },
            confirmButton = {
                TextButton(onClick = {
                    showPermission = false
                    val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
                    context.startActivity(intent)
                }) { Text("Mở cài đặt") }
            },
            title = { Text("Cần quyền") },
            text = { Text("Cho phép app thay đổi cài đặt hệ thống.") }
        )
    }
}