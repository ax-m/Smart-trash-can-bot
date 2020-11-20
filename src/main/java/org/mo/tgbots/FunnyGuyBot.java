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
                if(containsNo(message.getText())) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText(getGreeting());
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

    private boolean containsNo(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[,.!?\\\\-]", "");
        String[] words = text.split(" ");
        for(int i = 0;i < words.length;i++) {
            if(words[i].equals("hi") || words[i].equals("ні") || words[i].equals("hі") || words[i].equals("нi")) {
                return true;
            }
        }
        return false;
    }

    private String getGreeting() {
        String[] greetings = {"Hello", "Hi", "Привіт", "Здарова чмо", "Всем привет, с вами Навальный!",
        "О, ви з Англії?", "org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException: Error removing old webhook",
        "..."};
        return greetings[(int)(Math.random() * greetings.length)];
    }

}
