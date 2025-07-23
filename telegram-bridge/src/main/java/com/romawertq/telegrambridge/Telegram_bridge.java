package com.romawertq.telegrambridge;


import org.bukkit.plugin.java.JavaPlugin;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public final class Telegram_bridge extends JavaPlugin {

    private bot telegramBot; // <-- Должно быть здесь

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("Telegram Bridge включён!");

        String botToken = getConfig().getString("bot.token");
        String chatId = getConfig().getString("bot.chat-id");
        String botUsername = getConfig().getString("bot.username");
        int topicId = getConfig().getInt("bot.topic-id");

        // Проверка
        if (botToken == null || botToken.isEmpty()) {
            getLogger().severe("Токен не задан!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (chatId == null || chatId.isEmpty()) {
            getLogger().severe("Chat ID не задан!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (botUsername == null || botUsername.isEmpty()) {
            getLogger().severe("Имя бота не задано!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Создаём бота
        telegramBot = new bot(botToken, chatId, botUsername, topicId);

        // Регистрируем бота в Telegram
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(telegramBot);
            getLogger().info("Бот @" + botUsername + " успешно подключён к Telegram!");
        } catch (TelegramApiException e) {
            getLogger().severe("Ошибка подключения к Telegram: " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Регистрируем слушатели (важно!)
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
    }

    public bot getTelegramBot() {
        return telegramBot;
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
