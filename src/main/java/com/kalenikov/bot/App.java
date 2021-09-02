package com.kalenikov.bot;

import com.kalenikov.bot.telegram.Bot;
import com.kalenikov.bot.telegram.HelpCommand;
import com.kalenikov.bot.telegram.NextCommand;
import com.kalenikov.utils.HibernateUtil;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        bot.register(new HelpCommand("help", "help"));
        bot.register(new NextCommand("next", "next"));
        botsApi.registerBot(bot);

        HibernateUtil.getSessionFactory();

        SendMessage message = new SendMessage();
        message.setText("\uD83D\uDD25 hello, im load with hibernate");
        message.setChatId(String.valueOf(Config.ADMIN_ID));
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
