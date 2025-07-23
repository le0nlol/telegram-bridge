package com.romawertq.telegrambridge;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot {

    private final String botToken;
    private final String chatId;
    private final String botUsername;
    private final int topicId;

    public bot(String botToken, String chatId, String botUsername, int topicId) {
        this.botToken = botToken;
        this.chatId = chatId;
        this.botUsername = botUsername;
        this.topicId = topicId;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Можно оставить пустым, если не нужно читать сообщения из Telegram
    }

    // Метод для отправки сообщения в Telegram
    public void sendMessage(String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setMessageThreadId(topicId);
        message.setText(text);

        try {
            execute(message); // Отправляем
        } catch (TelegramApiException e) {
            System.out.println("[Telegram] Ошибка отправки: " + e.getMessage());
            e.printStackTrace();
        }
    }
}