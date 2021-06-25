package com.kalenikov.bot.store;

import com.kalenikov.model.Card;

import java.util.List;

public interface Store extends AutoCloseable {
    void init();

    Card save(Card item);

    boolean delete(int id);

    List<Card> findAll();

    List<Card> findByName(String key);

    Card findById(int id);

    Card next();
}