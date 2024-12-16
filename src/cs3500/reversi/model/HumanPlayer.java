package cs3500.reversi.model;

import cs3500.reversi.controller.IController;

/**
 * Represent a human player.
 * Implementation of {@link Player}.
 */
public class HumanPlayer implements Player {
  private ReversiModel model;
  private DiscType piece;

  /**
   * Constucts a human player.
   */
  public HumanPlayer(ReversiModel m) {
    this.model = m;
    this.piece = this.model.playerToAddType();
    this.model.addPlayer(this);
  }

  /**
   * Creates a player based on piece.
   *
   * @param p the piece
   */
  public HumanPlayer(DiscType p) {
    if (p != DiscType.BLACK && p != DiscType.WHITE) {
      throw new IllegalStateException("Invalid player type");
    }
    this.model = null;
    this.piece = p;
  }

  @Override
  public void addController(IController c) {
    // not needed for human player
  }

  @Override
  public String toString() {
    if (this.piece == DiscType.BLACK) {
      return "Player 1";
    } else {
      return "Player 2";
    }
  }

  @Override
  public void play() {
    //not needed for human players
  }

  @Override
  public DiscType getPiece() {
    return this.piece;
  }

}
