package me.cpjinan.messagefilter.listener

import me.cpjinan.playerchat.manager.ConfigManager
import org.bukkit.event.player.AsyncPlayerChatEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.adaptPlayer
import taboolib.module.kether.KetherShell

/**
 * author:      CPJiNan
 * project:     MessageFilter
 * package:     me.cpjinan.messagefilter.listener
 * className:   FilterEvent
 * date:        2023/1/1 10:55
 * description: 聊天消息过滤事件监听器
 */
object FilterEvent {

    /**
     * 玩家聊天事件处理方法
     */
    @SubscribeEvent
    fun onPlayerChat(event: AsyncPlayerChatEvent) {
        val playerChatMessage = filter(event.message, ConfigManager.filter.getStringList("rule.key"))
        if (event.isCancelled || event.message == playerChatMessage || !ConfigManager.filter.getBoolean("enable")) return
        if (!ConfigManager.filter.getBoolean("rule.setCancelled")) event.message = playerChatMessage else event.isCancelled = true
        KetherShell.eval(ConfigManager.filter.getStringList("action"), sender = adaptPlayer(event.player))
    }

    /**
     * 过滤消息的方法
     * @param message 待过滤的消息
     * @param key 过滤规则列表
     * @return 过滤后的消息
     */
    private fun filter(message:String, key:List<String>): String {
        var str = message
        for(item in key) {
            item.toRegex().findAll(message).forEach { result ->
                str = ConfigManager.filter.getString("rule.replace")?.let { str.replace(result.value, it) }.toString()
            }
        }
        return str
    }

}