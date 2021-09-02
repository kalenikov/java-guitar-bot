package com.kalenikov.bot.store;

import com.kalenikov.model.Card;
import com.kalenikov.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class JpaStore implements Store {

    private final SessionFactory sessionFactory;

    public JpaStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void init() {

    }

    @Override
    public Card save(Card item) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    @Override
    public List<Card> findByName(String key) {
        return null;
    }

    @Override
    public Card findById(int id) {
        return null;
    }

    @Override
    public Card next() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Card card = (Card) session
                .createQuery("from Card order by lastSeen")
                .setMaxResults(1).list().get(0);

        Query minmax = session.createQuery("select min(id),max(id) from Card ");

        session.createQuery("UPDATE Card SET lastSeen =:now WHERE id =:id")
                .setParameter("now", Timestamp.valueOf(LocalDateTime.now()))
                .setParameter("id", card.getId())
                .executeUpdate();
        tx.commit();
        session.close();
        return card;
    }

    public static void main(String[] args) {
        Store store = new JpaStore(HibernateUtil.getSessionFactory());
        Card card = store.next();
        System.out.println(card);
    }
}
