package com.kalenikov.bot.telegram;

import com.kalenikov.bot.store.JdbcStore;
import com.kalenikov.bot.store.JpaStore;
import com.kalenikov.bot.store.Store;
import com.kalenikov.model.Card;
import com.kalenikov.utils.HibernateSessionFactoryUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class NextCommand extends BaseCommand {
    public NextCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

        Store store = new JpaStore(HibernateSessionFactoryUtil.getSessionFactory());
        Card card = store.next();

        String userName = user.getUserName();
        System.out.printf("user %s. execute %s%n", userName, this.getCommandIdentifier());
        SendMessage sm = new SendMessage();
        sm.enableMarkdown(true);
        sm.setChatId(chat.getId().toString());
        sm.setText(card.getName());

        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        sm.setReplyMarkup(keyboard);
        keyboard.setSelective(true);
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(false);

        KeyboardRow row = new KeyboardRow();
        row.add("/next");
        keyboard.setKeyboard(List.of(row));

        try {
            absSender.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
