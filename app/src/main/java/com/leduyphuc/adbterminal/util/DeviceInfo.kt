package com.leduyphuc.adbterminal.util

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

object DeviceInfo {

    fun model(): String = "${Build.MANUFACTURER} ${Build.MODEL}"

    fun androidVersion(): String =
        "Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})"

    fun cpuCores(): String =
        "${Runtime.getRuntime().availableProcessors()} nhân"

    fun ramInfo(context: Context): String {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val info = ActivityManager.MemoryInfo()
        am.getMemoryInfo(info)
        val total = info.totalMem / (1024.0 * 1024.0 * 1024.0)
        val used = (info.totalMem - info.availMem) / (1024.0 * 1024.0 * 1024.0)
        return "%.1f / %.1f GB".format(used, total)
    }

    fun refreshRate(context: Context): String {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val hz = wm.defaultDisplay.refreshRate
        return "%.0f Hz".format(hz)
    }

    fun resolution(context: Context): String {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val metrics = DisplayMetrics()
        wm.defaultDisplay.getRealMetrics(metrics)
        return "${metrics.widthPixels} x ${metrics.heightPixels}"
    }

    fun density(context: Context): String {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val metrics = DisplayMetrics()
        wm.defaultDisplay.getRealMetrics(metrics)
        return "%.0f dpi".format(metrics.densityDpi)
    }

    fun supportsVulkan(): Boolean =
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

    fun hasMouse(context: Context): Boolean {
        val pm = context.packageManager
        return pm.hasSystemFeature("android.hardware.usb.host")
    }
}