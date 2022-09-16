package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.Entity.Game;
import org.example.Entity.Player;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

@UtilityClass
public class UtilConfig {
    private static String USER_NAME = "root";
    private static String PASSWORD = "1234";
    private static String URL = "jdbc:mysql://localhost:3306/dbtocrudapp";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static SessionFactory sessionFactory = UtilConfig.buildSessionFactory(UtilConfig.setConfig());

    public Configuration setConfig() {
        Properties settings = new Properties();
        settings.put(Environment.URL, URL);
        settings.put(Environment.DRIVER, DRIVER);
        settings.put(Environment.USER, USER_NAME);
        settings.put(Environment.PASS, PASSWORD);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "validate");
        settings.put(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(Game.class)
                .setProperties(settings);
        return configuration;
    }

    public SessionFactory buildSessionFactory(Configuration configuration) {
        try {
            return configuration.buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
