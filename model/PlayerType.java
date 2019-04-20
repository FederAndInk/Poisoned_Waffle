package model;

import controller.AI;
import controller.Player;
import controller.RandomAI;

public enum PlayerType {
  USER, //
  RANDOM_AI, //
  AI;

  public static Player create(PlayerType pt, Waffle waf) {
    switch (pt) {
    case USER:
      return new Player(waf);

    case RANDOM_AI:
      return new RandomAI(waf);

    case AI:
      return new AI(waf);
    }

    return null;
  }
}