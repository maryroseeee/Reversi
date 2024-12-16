package cs3500.reversi.controller;

import cs3500.reversi.model.Disc;

/**
 * Player - view listener interface.
 */
public interface PlayerListener {

  /**
   * Flips the disc.
   *
   * @param d the disc to flip.
   */
  void flip(Disc d);

  /**
   * Passes the current turn.
   */
  void pass();

}
