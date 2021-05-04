package com.kalenikov.bot;

import com.kalenikov.bot.telegram.Bot;
import com.kalenikov.bot.telegram.HelpCommand;
import com.kalenikov.bot.telegram.StartCommand;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            Bot bot = new Bot();
            bot.register(new StartCommand("start", "Старт"));
            bot.register(new HelpCommand("help", "help"));
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
