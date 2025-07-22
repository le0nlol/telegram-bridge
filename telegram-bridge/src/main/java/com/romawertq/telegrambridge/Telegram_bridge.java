package com.romawertq.telegrambridge;


import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public final class Telegram_bridge extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Hello world!");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents (new Commands(), this);
        TelegramBotsApi tgapi = null;
        try {
            tgapi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        try {
            tgapi.registerBot(new bot());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
