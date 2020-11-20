package org.mo.tgbots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if(message.hasText()) {
                String text = message.getText().toLowerCase();
                if(text.endsWith("ні") || text.endsWith("hi")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Hello");
                    sendMessage.setChatId(message.getChatId() + "");
                    sendMessage.setReplyToMessageId(message.getMessageId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}
