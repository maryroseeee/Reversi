package cs3500.reversi.model;

import cs3500.reversi.controller.IController;
import cs3500.reversi.strategy.MoveStrategy;

/**
 * Represents an AI Player in a reversi game.
 */
public class AIPlayer implements Player {
  private final DiscType piece;
  private final MoveStrategy strategy;
  private ReversiModel model;
  private IController controller;

  /**
   * Constructs an AI player.
   *
   * @param m the game model
   * @param strategy their strategy
   */
  public AIPlayer(ReversiModel m, MoveStrategy strategy) {
    this.model = m;
    this.piece = this.model.playerToAddType();
    this.strategy = strategy;
    this.model.addPlayer(this);
  }

  @Override
  public void addController(IController c) {
    this.controller = c;
  }

  @Override
  public void play() {
    this.controller.getGameView().briefPause();
    if (this.getPiece() == this.model.getCurrentTurn()) {
      try {
        this.controller.getGameView().notifyUserMove(this.strategy.chooseDisc(this.model,
                this.piece));
      } catch (IllegalStateException e) {
        this.controller.getGameView().notifyUserPass();
      }
    }
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
  public DiscType getPiece() {
    return this.piece;
  }



}
