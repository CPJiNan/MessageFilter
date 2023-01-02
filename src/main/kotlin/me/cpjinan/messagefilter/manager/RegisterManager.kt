package me.cpjinan.messagefilter.manager

import me.cpjinan.playerchat.manager.ConfigManager
import taboolib.common.platform.Platform
import taboolib.module.metrics.Metrics
import taboolib.platform.BukkitPlugin

/**
 * author:      CPJiNan
 * project:     MessageFilter
 * package:     me.cpjinan.messagefilter.manager
 * className:   RegisterManager
 * date:        2023/1/1 10:55
 * description: 注册相关工具类
 */
object RegisterManager {

    /**
     * 快捷注册方法
     */
    fun registerAll() {
        registerMetrics()
    }

    /**
     * bStats统计注册方法
     */
    fun registerMetrics() {
        if (ConfigManager.options.getBoolean("metrics")) Metrics(17257, BukkitPlugin.getInstance().description.version, Platform.BUKKIT)
    }


}