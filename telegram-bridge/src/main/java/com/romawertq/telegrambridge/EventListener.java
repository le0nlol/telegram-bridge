package com.romawertq.telegrambridge;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;

public class EventListener implements Listener {

    private final Telegram_bridge plugin;

    public EventListener(Telegram_bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String message = "✅ " + event.getPlayer().getName() + " зашёл на сервер!";
        plugin.getTelegramBot().sendMessage(message);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String message = "❌ " + event.getPlayer().getName() + " вышел с сервера.";
        plugin.getTelegramBot().sendMessage(message);
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String message = "💬 [" + event.getPlayer().getName() + "] " + event.getMessage();
        plugin.getTelegramBot().sendMessage(message);
    }
    @EventHandler
    public void serverstart(PluginEnableEvent event){
        String k = "Просыпаемся, сервер запущен!";
        System.out.println("k nerabotati");
        plugin.getTelegramBot().sendMessage(k);
        System.out.println("k rabotati");
    }
    @EventHandler
    public void serverstop(PluginDisableEvent event){
        String r = "Пора спать, сервер тоже спать!";
        System.out.println("r nerabotati");
        plugin.getTelegramBot().sendMessage(r);
        System.out.println("r rabotati");
    }
}
