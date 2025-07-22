package com.romawertq.telegrambridge;


import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Telegram_bridge extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Hello world!");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents (new Commands(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
