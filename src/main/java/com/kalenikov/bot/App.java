package com.kalenikov.bot;

import com.kalenikov.bot.store.JdbcStore;
import com.kalenikov.bot.store.JpaStore;
import com.kalenikov.bot.store.Store;
import com.kalenikov.bot.telegram.Bot;
import com.kalenikov.bot.telegram.HelpCommand;
import com.kalenikov.bot.telegram.NextCommand;
import com.kalenikov.bot.telegram.StartCommand;
import com.kalenikov.model.Card;
import com.kalenikov.utils.HibernateSessionFactoryUtil;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {

    public static void main(String[] args) {
        Store store = new JpaStore(HibernateSessionFactoryUtil.getSessionFactory());
        Card card = store.next();
        System.out.println(card);
//        try {
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            Bot bot = new Bot();
//            bot.register(new StartCommand("start", "start"));
//            bot.register(new HelpCommand("help", "help"));
//            bot.register(new NextCommand("next", "next"));
//            botsApi.registerBot(bot);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }
    
}
