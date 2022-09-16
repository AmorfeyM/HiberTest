package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.Entity.Game;
import org.example.Entity.Player;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;

@UtilityClass
public class FillTables {
    private static final Session openSession = UtilConfig.getSessionFactory().openSession();

    public static void fillTables() {
        Game godOfWar = Game.builder()
                .title("GodOfWar")
                .playtime(100)
                .build();
        Game wither = Game.builder()
                .title("Wither")
                .playtime(200)
                .build();
        Game cyberpunk = Game.builder()
                .title("Cyberpunk")
                .playtime(300)
                .build();
        Player sergey = Player.builder()
                .name("Sergey")
                .username("Amorfeym")
                .build();
        sergey.setGame(wither);
        sergey.setGame(cyberpunk);
        sergey.setGame(godOfWar);
        wither.setPlayer(sergey);
        cyberpunk.setPlayer(sergey);
        godOfWar.setPlayer(sergey);

        try {
            openSession.beginTransaction();
            openSession.save(wither);
            openSession.save(cyberpunk);
            openSession.save(godOfWar);
            openSession.save(sergey);
            openSession.getTransaction().commit();
        } catch (HibernateException e) {
            openSession.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            openSession.close();
        }
    }
}
