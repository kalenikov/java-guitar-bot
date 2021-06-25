package com.kalenikov.bot.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class MenuBuilder {
    ReplyKeyboardMarkup replyKeyboardMarkup;
    SendMessage sm;

    public MenuBuilder(SendMessage sm) {
        this.sm = sm;
    }

    public ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        ReplyKeyboardMarkup keys = new ReplyKeyboardMarkup();
        sm.setReplyMarkup(keys);
        return replyKeyboardMarkup;
    }

}

// SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);

//        // Создаем клавиуатуру
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        // Создаем список строк клавиатуры
//        List<KeyboardRow> keyboard = new ArrayList<>();
//
//        // Первая строчка клавиатуры
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//        // Добавляем кнопки в первую строчку клавиатуры
//        keyboardFirstRow.add("Команда 1");
//        keyboardFirstRow.add("Команда 2");
//
//        // Вторая строчка клавиатуры
//        KeyboardRow keyboardSecondRow = new KeyboardRow();
//        // Добавляем кнопки во вторую строчку клавиатуры
//        keyboardSecondRow.add("Команда 3");
//        keyboardSecondRow.add("Команда 4");
//
//        // Добавляем все строчки клавиатуры в список
//        keyboard.add(keyboardFirstRow);
//        keyboard.add(keyboardSecondRow);
//        // и устанваливаем этот список нашей клавиатуре
//        replyKeyboardMarkup.setKeyboard(keyboard);
//
//        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(text);
//        try {
//            sendMessage(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }

//3
//
//Ответ был найден методом проб и ошибок.
//                1) Ставим в методе sendMsg на параметре replyKeyboardMarkup.setOneTimeKeyboard - (true);
//2) На каждый case создаем отдельный метод.
//                На команду 1 - sendMsgcom1 с однима набором кнопок,
//                на команду 2 - sensMsg2 с другим набором кнопок.

//Всем привет! Начал понемногу осваивать ботов в телеграме.
// Знаю немного Java. Сейчас работает бот, который через switch
// проходит по нужным ответам и выдает то, что ему задано. Добавил
// 4 кнопки: команда 1, команда 2, команда 3 и команда 4. Они выполняют
// свою функцию. При любом ответе эти поля остаются, а хотелось бы, чтобы они
// менялись. Допустим, пользователь выбрал кнопку "Команда 1", а ему в ответ
// предложили 2 варианта вопроса, например "команда 1-1", "команда 1-2", команда "3-1" etc.
