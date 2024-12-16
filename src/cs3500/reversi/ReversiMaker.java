package cs3500.reversi;

import java.io.IOException;
import java.util.Scanner;

import cs3500.reversi.controller.IController;
import cs3500.reversi.controller.ReversiController;
import cs3500.reversi.model.BasicReversi;
import cs3500.reversi.model.ReversiModel;
import cs3500.reversi.strategy.Strategies;
import cs3500.reversi.view.IView;
import cs3500.reversi.view.ReversiGraphicsView;

/**
 * Makes a reversi game.
 */
public class ReversiMaker {

  private Readable readable;
  private Appendable appendable;
  private ReversiModel model;

  /**
   * Constructs a Reversi maker.
   * @param r the readable input
   * @param a the appendable output
   */
  public ReversiMaker(Readable r, Appendable a) {
    if ((r == null) || (a == null)) {
      throw new IllegalArgumentException("Readable or appendable is null");
    }
    this.readable = r;
    this.appendable = a;
    this.model = new BasicReversi();
  }

  /**
   * The primary method for beginning and playing a game.
   *
   * @throws IOException If the Appendable object is unable to transmit output
   */
  public void playGame() throws IOException {
    Scanner sc = new Scanner(this.readable);
    this.appendable.append("There are 6 strategies:\n" + Strategies.asAList() + "\n"
            + "You may start the game by:\n" +
            "-typing two corresponding numbers (with a space between them on the same line)\n"
            + "-Just hit enter and the 2 players will automatically become human players\n" +
            "-Only entering one number will make the other automatically become a human player\n" +
            "Only valid numbers typed will be chosen (1 - 6), all others will be ignored \n" +
            "You make type your response here:");
    if (sc.hasNextLine()) {
      String line = sc.nextLine().toLowerCase();
      Scanner lineScanner = new Scanner(line);
      addInt(lineScanner);
    }
    IView view1 = new ReversiGraphicsView(model);
    IView view2 = new ReversiGraphicsView(model);
    IController controller1 = new ReversiController(model, this.model.getPlayer1(), view1);
    IController controller2 = new ReversiController(model, model.getPlayer2(), view2);
    this.model.play();
  }

  /**
   * Gets the next valid int in a scanner and adds the player to the model.
   *
   * @param sc the command line command
   */
  public void addInt(Scanner sc) {
    while (sc.hasNext()) {
      if (sc.hasNextInt()) {
        int x = sc.nextInt();
        if (x <= 6 && x > 0) {
          Strategies.createPlayer(Strategies.getStratByVal(x), this.model);
        }
      }
    }
  }

}
