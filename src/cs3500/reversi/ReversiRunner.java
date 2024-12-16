package cs3500.reversi;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to run a reversi game.
 */
public class ReversiRunner {
  /**
   * Main method to run a reversi game.
   */
  public static void main(String[] args) {
    try {
      new ReversiMaker(new InputStreamReader(System.in), System.out).playGame();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
