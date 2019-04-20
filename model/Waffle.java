package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Class Waffle
 */
public class Waffle extends Observable {

  //
  // Fields
  //

  private Coord size;

  private ArrayList<ArrayList<Boolean>> tiles;

  /**
   * @param sizeX
   * @param sizeY
   */
  public Waffle(int sizeX, int sizeY) {
    size = new Coord(sizeX, sizeY);
    tiles = new ArrayList<>(size.getY());
    for (ArrayList<Boolean> line : tiles) {
      line = new ArrayList<>();
      for (int i = 0; i < size.getX(); i++) {
        line.add(true);
      }
    }
  }

  public Waffle(Coord wafSize) {
    this(wafSize.getX(), wafSize.getY());
  }

  //
  // Methods
  //

  /**
   * @param to
   */
  public void eat(Coord to) {
    for (int i = to.getY(); i < size.getY(); i++) {
      for (int j = to.getX(); j < size.getX(); j++) {
        Coord toEat = new Coord(j, i);
        set(toEat, false);
      }
    }
    notifyObservers();
  }

  /**
   * @return boolean
   * @param to
   */
  public boolean canEat(Coord to) {
    return get(to);
  }

  /**
   * @return boolean
   * @param to
   */
  public boolean isPoisonned(Coord to) {
    return to.equals(new Coord(0, 0));
  }

  //
  // Accessor methods
  //

  /**
   * @return the size
   */
  public Coord getSize() {
    return size;
  }

  private boolean get(Coord to) {
    return tiles.get(to.getY()).get(to.getX());
  }

  private void set(Coord to, boolean val) {
    tiles.get(to.getY()).set(to.getX(), val);
  }

  //
  // Other methods
  //
}
