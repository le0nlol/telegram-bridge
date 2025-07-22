package com.romawertq.telegrambridge;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot  {
    @Override
    public void onUpdateReceived(Update update) {

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
        return "";
    }
    @Override
    public String getBotToken(){
        return "";
    }
}