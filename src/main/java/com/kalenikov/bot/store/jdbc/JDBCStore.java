package com.kalenikov.bot.store.jdbc;

import com.kalenikov.bot.store.Store;
import com.kalenikov.model.Card;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class JDBCStore implements Store {

    private static final class SingletonHolder {
        private static final JDBCStore INSTANCE = new JDBCStore();
    }

    public static JDBCStore getInstance() throws SQLException {
        return JDBCStore.SingletonHolder.INSTANCE;
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
    public List<Card> findAll() throws SQLException {
        Connection cn = ConnectionPool.getConnection();
        QueryRunner runner = new QueryRunner();
        return runner.query(cn, "SELECT * FROM cards",
                new CardListHandler());
    }

    @Override
    public List<Card> findByName(String name) {
        return null;
    }


    @Override
    public Card get(int id) throws SQLException {
        Connection cn = ConnectionPool.getConnection();
        QueryRunner runner = new QueryRunner();
//        BeanListHandler<Card> beanListHandler = new BeanListHandler<>(Card.class);
//        var rsl = runner.query(cn, "SELECT * FROM cards WHERE id=?", beanListHandler, id);
//        var rsl = runner.query(cn, "SELECT * FROM cards WHERE id=?", beanListHandler, id).get(0);
        var rsl = runner.query(cn, "SELECT * FROM cards",
                new CardListHandler());

        return rsl.get(0);
    }


    @Override
    public Card next() throws SQLException {
        log.debug("next call");
        Connection cn = ConnectionPool.getConnection();
        QueryRunner runner = new QueryRunner();
        Card rsl = runner.query(cn,
                        "SELECT * FROM cards order by time_last_seen limit 1",
                        new CardListHandler())
                .get(0);
        int num = runner.update(cn,
                "UPDATE cards SET time_last_seen=? WHERE id = ?",
                Timestamp.valueOf(LocalDateTime.now()),
                rsl.getId());
        return rsl;
    }

    public static void main(String[] args) throws SQLException {
        JDBCStore store = new JDBCStore();
//        var all = store.findAll();
//        all.forEach(System.out::println);
        System.out.println(store.next());
    }
}
