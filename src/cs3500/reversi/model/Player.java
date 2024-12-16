package cs3500.reversi.model;

import cs3500.reversi.controller.IController;

/**
 * Interface that represents the model for a player in the game of Reversi.
 */
public interface Player {

  /**
   * Adds a controller to a player.
   *
   * @param c controller to add.
   */
  void addController(IController c);

  /**
   * Starts the players move.
   */
  void play();

  /**
   * Returns player's disc type.
   *
   * @return player's disc type.
   */
  DiscType getPiece();
}
