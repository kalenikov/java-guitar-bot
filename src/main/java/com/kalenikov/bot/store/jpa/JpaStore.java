package com.kalenikov.bot.store.jpa;

public class JpaStore  {

//    private final SessionFactory sessionFactory;
//
//    public JpaStore(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void init() {
//
//    }
//
//    @Override
//    public Card save(Card item) {
//        return null;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return false;
//    }
//
//    @Override
//    public List<Card> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Card> findByName(String key) {
//        return null;
//    }
//
//    @Override
//    public Card get(int id) {
//        return null;
//    }
//
//    @Override
//    public Card next() {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        Card card = (Card) session
//                .createQuery("from Card order by lastSeen")
//                .setMaxResults(1).list().get(0);
//
//        Query minmax = session.createQuery("select min(id),max(id) from Card ");
//
//        session.createQuery("UPDATE Card SET lastSeen =:now WHERE id =:id")
//                .setParameter("now", Timestamp.valueOf(LocalDateTime.now()))
//                .setParameter("id", card.getId())
//                .executeUpdate();
//        tx.commit();
//        session.close();
//        return card;
//    }
//
//    public static void main(String[] args) throws SQLException {
//        Store store = new JpaStore(HibernateUtil.getSessionFactory());
//        Card card = store.next();
//        System.out.println(card);
//    }
}
