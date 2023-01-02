package me.cpjinan.playerchat.manager

import taboolib.library.configuration.ConfigurationSection
import taboolib.module.chat.colored
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigNode
import taboolib.module.configuration.Configuration

object ConfigManager {
    private const val configFile = "config.yml"

    @Config(configFile, autoReload = true)
    lateinit var config : Configuration
    @ConfigNode("options", configFile)
    lateinit var options: ConfigurationSection
    @ConfigNode("module.filter", configFile)
    lateinit var filter: ConfigurationSection

}