package org.example.dao;

import org.example.Entity.Game;
import org.example.Entity.Player;
import org.example.util.UtilConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GameDaoImpl {
    private static final SessionFactory sessionFactory = UtilConfig.getSessionFactory();

    public static Game findGameById(Long id) {
        Session openSession = sessionFactory.openSession();
        try {
            openSession.beginTransaction();
            Game game = openSession.get(Game.class, 1L);
            openSession.getTransaction().commit();
            return game;
        } catch (HibernateException e) {
            openSession.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            openSession.close();
        }
    }

    public static List<Player> getPlayersByGame(Game game) {
        Session openSession = sessionFactory.openSession();
        try {
            openSession.beginTransaction();
            List<Player> games = game.getPlayers();
            openSession.getTransaction().commit();
            return games;
        } catch (HibernateException e) {
            openSession.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            openSession.close();
        }
    }
}
