package com.romawertq.telegrambridge;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import static org.bukkit.Bukkit.getServer;

public class bot extends TelegramLongPollingBot implements Listener {
    @Override
    public void onUpdateReceived(Update update) {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Commands(), (Plugin) this);
        String chatId = update.getMessage().getChatId().toString();
        String Text = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(Text);


        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "onlineserverle0n_bot";
    }

    @Override
    public String getBotToken() {
        return "7725985929:AAFJsqfj84G0GKQQ2WgL87GXp9ykuraWp7k";
    }


}