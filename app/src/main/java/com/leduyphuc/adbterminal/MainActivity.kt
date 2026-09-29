package com.leduyphuc.adbterminal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.leduyphuc.adbterminal.ui.*
import com.leduyphuc.adbterminal.ui.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppRoot()
            }
        }
    }
}

enum class Screen(val label: String, val icon: ImageVector) {
    Home("Trang chủ", Icons.Default.Home),
    Performance("Hiệu năng", Icons.Default.Star),
    Graphics("Đồ họa", Icons.Default.Star),
    Touch("Cảm ứng", Icons.Default.Star),
    Settings("Cài đặt", Icons.Default.Settings)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot() {
    var current by remember { mutableStateOf(Screen.Home) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Device Tuner") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                Screen.entries.forEach { screen ->
                    NavigationBarItem(
                        selected = current == screen,
                        onClick = { current = screen },
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label, maxLines = 1) }
                    )
                }
            }
        }
    ) { padding ->
        val mod = Modifier.padding(padding)
        when (current) {
            Screen.Home -> HomeScreen(context, mod)
            Screen.Performance -> PerformanceScreen(context, mod)
            Screen.Graphics -> GraphicsScreen(mod)
            Screen.Touch -> TouchScreen(context, mod)
            Screen.Settings -> SettingsScreen(mod)
        }
    }
}