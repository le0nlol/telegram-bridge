package com.romawertq.telegrambridge;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot implements Listener {
    private String f;
    private String g;
    private String k;
    private String r;
    private String message;
    private String NamePlayer;
    public String botToken;
    public String chatId;
    public int topicId;


    @Override
    public void onUpdateReceived(Update update) {
        if (!f.isEmpty()){
            SendMessage message = new SendMessage();
            message.setChatId(chatId.toString());
            message.setMessageThreadId(topicId); // Устанавливаем ID топика
            message.setText(f);
        }
        if (!g.isEmpty()){
            SendMessage message = new SendMessage();
            message.setChatId(chatId.toString());
            message.setMessageThreadId(topicId); // Устанавливаем ID топика
            message.setText(g);
        }
    }


    @Override
    public String getBotUsername() {
        return getBotToken();
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @EventHandler
    public void playerjoin(PlayerJoinEvent event){
        f = event.getPlayer().getDisplayName() + " зашёл на сервер!";
    }
    @EventHandler
    public void playerquit(PlayerQuitEvent event){
        g = event.getPlayer().getDisplayName() + " вышел с сервера!";
    }
    @EventHandler
    public void playerchat(PlayerChatEvent event){
        message = event.getMessage();
        NamePlayer = event.getPlayer().getName();
    }

    @EventHandler
    public void serverstart(PluginEnableEvent event){
        k = "Просыпаемся, сервер запущен!";
    }
    @EventHandler
    public void serverstop(PluginDisableEvent event){
        r = "Пора спать, сервер тоже спать!";
    }

}
class botik extends bot  {
    public botik(String hyp, String gyp, int value) {
        this.topicId = value;
        this.botToken = hyp;
        this.chatId = gyp;
    }
}