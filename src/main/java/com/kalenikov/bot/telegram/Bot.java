package com.kalenikov.bot.telegram;

import com.kalenikov.bot.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public final class Bot extends TelegramLongPollingCommandBot {
    private static final Logger log = LoggerFactory.getLogger(Bot.class.getName());

    public Bot() {
        super();
    }

    @Override
    public String getBotToken() {
        return Config.TOKEN;
    }

    @Override
    public String getBotUsername() {
        return Config.BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        String messageText = msg.getText();
        String user = msg.getFrom().getFirstName();
        boolean isAdmin = Config.isAdmin(msg.getFrom().getId());

        log.info("processNonCommandUpdate, " +
                        "user: {}, " +
                        "isAdmin: {}, " +
                        "messageText: {}",
                user, isAdmin,  messageText);
//        String textAnswer = null;
        String targetChatId = msg.getChatId().toString();


//        if (!isAdmin) {
//        } else {
//            textAnswer = messageText;
//            targetChatId = Config.getChatId();
//        }


//        if (textAnswer != null) {
        SendMessage answer = new SendMessage();
        answer.setText("пустая команда");
        answer.setChatId(targetChatId);
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
//        }
    }

}