package com.kalenikov.bot;

import com.kalenikov.bot.store.jdbc.ConnectionPool;
import com.kalenikov.bot.telegram.Bot;
import com.kalenikov.bot.telegram.HelpCommand;
import com.kalenikov.bot.telegram.NextCommand;
import com.kalenikov.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

@Slf4j
public class App {
    public static void main(String[] args) throws TelegramApiException, SQLException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        bot.register(new HelpCommand("help", "help"));
        bot.register(new NextCommand("next", "next"));
        botsApi.registerBot(bot);

        ConnectionPool.getConnection();

        log.debug("hello, im load with jdbc");

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
