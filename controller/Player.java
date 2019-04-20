package controller;

import model.Coord;
import model.Waffle;

/**
 * Class Player
 */
public class Player {

  //
  // Fields
  //
  private Coord nextMove;
  protected Waffle waf;

  //
  // Constructors
  //

  public Player(Waffle waf) {
    this.waf = waf;
  }

  //
  // Methods
  //

  //
  // Accessor methods
  //

  /**
   * @return Coord
   */
  public Coord nextPlay() {
    return nextMove;
  }

  /**
   * @param next
   */
  public void setNextPlay(Coord next) {
    nextMove = next;
  }

  //
  // Other methods
  //

}
