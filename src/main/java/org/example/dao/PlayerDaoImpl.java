package org.example.dao;

import org.example.Entity.Game;
import org.example.Entity.Player;
import org.example.util.UtilConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class PlayerDaoImpl {
    private static final SessionFactory sessionFactory = UtilConfig.getSessionFactory();

    public static List<Game> getGamesByPlayer(Player player) {
        Session openSession = sessionFactory.openSession();
        try {
            openSession.beginTransaction();
            List<Game> games = player.getGames();
            openSession.getTransaction().commit();
            return games;
        } catch (HibernateException e) {
            openSession.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            openSession.close();
        }
    }

    public static Player findPlayerById(Long id) {
        Session openSession = sessionFactory.openSession();
        try {
            openSession.beginTransaction();
            Player player = openSession.get(Player.class, 1L);
            System.out.println(player);
            player.getGames().forEach(System.out::println);
            openSession.getTransaction().commit();
            return player;
        } catch (HibernateException e) {
            openSession.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            openSession.close();
        }
    }
}
