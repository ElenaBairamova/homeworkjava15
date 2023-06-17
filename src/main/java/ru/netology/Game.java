package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();


    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException{
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

              if (player1 == null || player2 == null) {
                  throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегистрирован");
              }

        if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else {
                if (player1.getStrength() < player2.getStrength()) {
                    return 2;
                }
            } return 0;

        }
    }

