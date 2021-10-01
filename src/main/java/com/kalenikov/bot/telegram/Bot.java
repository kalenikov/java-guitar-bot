package com.kalenikov.bot.telegram;

import com.kalenikov.bot.Config;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public final class Bot extends TelegramLongPollingCommandBot {

    public Bot() {
        super();
        log.debug("bot created");
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
        SendMessage answer = new SendMessage();
        answer.setText("пустая команда от " + msg.getFrom().getFirstName());
        answer.setChatId(msg.getChatId().toString());
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}