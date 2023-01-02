package me.cpjinan.messagefilter

import me.cpjinan.messagefilter.manager.RegisterManager
import taboolib.common.platform.Plugin

object MessageFilter : Plugin() {

    override fun onEnable() {
        RegisterManager.registerAll()
    }

}