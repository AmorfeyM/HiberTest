package org.example;

import org.example.dao.GameDaoImpl;
import org.example.dao.PlayerDaoImpl;
import org.example.util.FillTables;
import org.example.util.UtilConfig;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        UtilConfig.setConfig();
//        FillTables.fillTables();
        PlayerDaoImpl.findPlayerById(1L);
//        PlayerDaoImpl.getGamesByPlayer(PlayerDaoImpl.findPlayerById(1L));
//
//        GameDaoImpl.findGameById(1L);
//        GameDaoImpl.getPlayersByGame(GameDaoImpl.findGameById(1L));
    }
}
