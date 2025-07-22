package com.romawertq.telegrambridge;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public final class Telegram_bridge extends JavaPlugin implements Listener {
    private String botToken;
    private String chatId;
    private int topicId;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("Hello world!");
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

        botToken = getConfig().getString("bot.token");
        chatId = getConfig().getString("bot.chat-id");
        topicId = getConfig().getInt("bot.topic-id");

    }

    public static void main(String[] args) {
        botik a = new botik();
        String value = a.getData();
        System.out.println(value); // Вывод значения: "Значение из ClassB"
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
