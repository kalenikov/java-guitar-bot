package com.kalenikov.bot.store.jdbc;

import com.kalenikov.model.Card;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.HashMap;
import java.util.Map;

public class CardListHandler extends BeanListHandler<Card> {

    public CardListHandler() {
        super(Card.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    public static Map<String, String> mapColumnsToFields() {
        Map<String, String> columnsToFieldsMap = new HashMap<>();
        columnsToFieldsMap.put("time_last_seen", "lastSeen");
        columnsToFieldsMap.put("name", "name");
        return columnsToFieldsMap;
    }
}
