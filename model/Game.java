package model;

import controller.Player;

/**
 * Class Game
 */
public class Game {

  //
  // Fields
  //
  private Waffle waf;

  private Player pCur;
  private Player player1;
  private Player player2;

  //
  // Constructors
  //

  //
  // Methods
  //

  //
  // Accessor methods
  //
  public Waffle getWaffle() {
    return this.waf;
  }

  private void switchCurrentPlayer() {
    if (pCur == player1) {
      pCur = player2;
    } else {
      pCur = player1;
    }
  }

  //
  // Other methods
  //

  /**
   * @param p1
   * @param p2
   */
  public void begin(PlayerType p1, PlayerType p2, Coord wafSize) {
    waf = new Waffle(wafSize);

    player1 = PlayerType.create(p1, waf);
    player2 = PlayerType.create(p2, waf);
    pCur = player1;
  }

  /**
   * @param to
   */
  public void play(Coord to) {
    pCur.setNextPlay(to);
    waf.eat(pCur.nextPlay());

    switchCurrentPlayer();
  }

}
