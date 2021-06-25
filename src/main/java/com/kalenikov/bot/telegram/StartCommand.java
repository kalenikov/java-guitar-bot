package com.kalenikov.bot.telegram;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;


public class StartCommand extends BaseCommand {

    public StartCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = user.getUserName();
        System.out.printf("user %s. execute %s%n", userName, this.getCommandIdentifier());
        sendAnswer(absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                userName,
                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
    }
}