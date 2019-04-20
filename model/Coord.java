package model;

/**
 * Class Coord
 */
public class Coord {

  //
  // Fields
  //

  private int x;
  private int y;

  //
  // Constructors
  //
  /**
   * @param x
   * @param y
   */
  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }

  //
  // Methods
  //

  //
  // Accessor methods
  //

  /**
   * Get the value of x
   * 
   * @return the value of x
   */
  public int getX() {
    return x;
  }

  /**
   * Get the value of y
   * 
   * @return the value of y
   */
  public int getY() {
    return y;
  }

  //
  // Other methods
  //

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coord) {
      Coord c = (Coord) obj;
      return c.x == x && c.y == y;
    }
    return false;
  }

}
