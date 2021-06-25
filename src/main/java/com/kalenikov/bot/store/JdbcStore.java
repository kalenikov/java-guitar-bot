package com.kalenikov.bot.store;

import com.kalenikov.model.Card;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class JdbcStore implements Store {
    private static JdbcStore instance;
    private Connection cn;

    private JdbcStore() {
    }

    public JdbcStore(Connection connection) {
        this.cn = connection;
    }

    public static JdbcStore getInstance() {
        if (instance == null) {
            instance = new JdbcStore();
            instance.init();
        }
        return instance;
    }

    @Override
    public void init() {
        try (InputStream in = JdbcStore.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Card save(Card item) {
        try (PreparedStatement ps = cn.prepareStatement("insert into cards(id,name,time_last_seen) values(?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setTimestamp(3, item.getLastSeen());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return item;
    }


    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement("delete from random_cards.public.cards where id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Card> findAll() {
        List<Card> rsl = new ArrayList<>();
        try (Statement ps = cn.createStatement()) {
            ps.executeQuery("select * from cards order by id");
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                rsl.add(new Card(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("time_last_seen")
                ));
            }
            return rsl;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Card> findByName(String key) {
        List<Card> rsl = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from cards where name = ? order by id")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rsl.add(new Card(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("time_last_seen")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Card findById(int id) {
        try (PreparedStatement ps = cn.prepareStatement("select * from cards where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Card(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("time_last_seen")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Card next() {
        Card card;
        try (PreparedStatement ps = cn.prepareStatement("select * from cards order by time_last_seen limit 1")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                card = new Card(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("time_last_seen")
                );
                card.setLastSeen(Timestamp.valueOf(LocalDateTime.now()));
                save(card);
                return card;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
