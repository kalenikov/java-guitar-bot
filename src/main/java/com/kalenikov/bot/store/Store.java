package com.kalenikov.bot.store;

import com.kalenikov.model.Card;

import java.sql.SQLException;
import java.util.List;

public interface Store{
    void init();

    Card save(Card item);

    boolean delete(int id);

    List<Card> findAll() throws SQLException;

    List<Card> findByName(String name);

    Card get(int id) throws SQLException;

    Card next() throws SQLException;
}