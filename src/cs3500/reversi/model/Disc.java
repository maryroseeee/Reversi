package cs3500.reversi.model;

import java.util.Objects;

/**
 * Represents a disc.
 */
public class Disc {
  private DiscType type;
  private DiscPosn posn;

  /**
   * Constructs a disc based on type and position.
   *
   * @param t disc type.
   * @param p disc position.
   */
  public Disc(DiscType t, DiscPosn p) {
    this.type = t;
    this.posn = p;
  }

  /**
   * Constructs disc based on type.
   *
   * @param t of disc
   */
  public Disc(DiscType t) {
    this.type = t;
    this.posn = null;
  }

  public Disc(DiscPosn p) {
    this.posn = p;
  }

  @Override
  public String toString() {
    return this.type.toString() + " " + this.posn.toString();
  }

  /**
   * Returns the disc's type.
   *
   * @return the disc's type
   */
  public DiscType getType() {
    return this.type;
  }

  /**
   * Returns the disc's position.
   *
   * @return the disc's position
   */
  public DiscPosn getPosn() {
    return this.posn;
  }

  public boolean sameType(DiscType other) {
    return this.type == other;
  }

  /**
   * Updates the disc type and returns it.
   *
   * @param t the new type
   * @return the disc with its new type
   */
  public Disc updateType(DiscType t) {
    this.type = t;
    return this;
  }

  /**
   * Gets the disc's the q-coordinate.
   *
   * @return the disc's the q-coordinate
   */
  public int getQ() {
    return this.posn.getQ();
  }

  /**
   * Gets the disc's the r-coordinate.
   *
   * @return the disc's the r-coordinate
   */
  public int getR() {
    return this.posn.getR();
  }

  /**
   * Gets the disc's the z-coordinate.
   *
   * @return the disc's the z-coordinate
   */
  public int getZ() {
    return this.posn.getZ();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Disc)) {
      return false;
    }
    Disc other = (Disc) o;
    return this.posn.equals(other.posn) && this.type == other.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.posn, this.type);
  }


}