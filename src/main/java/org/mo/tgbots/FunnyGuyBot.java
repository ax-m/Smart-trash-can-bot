package org.mo.tgbots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FunnyGuyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return System.getenv("TelegramBotUsername");
    }

    @Override
    public String getBotToken() {
        return System.getenv("TelegramBotToken");
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("New update: \n" + update);
    }
}
