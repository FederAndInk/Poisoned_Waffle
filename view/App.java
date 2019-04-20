package view;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Game;
import model.Waffle;

/**
 * App
 */
public class App extends Application implements Observer {
  Game game;

  @Override
  public void init() throws Exception {
    super.init();
    game = new Game();

  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    // TODO: when we know p1 and p2:
    // game.begin(PlayerType.USER, PlayerType.USER, new Coord(10, 20));

    // TODO: UI menu
    // TODO: UI game

    primaryStage.show();
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof Waffle) {
      Waffle waf = (Waffle)o;
      draw(waf);
    }
  }

  private void draw(Waffle waf) {
    for (int y = 0; y < waf.getSize().getY(); y++) {
      for (int x = 0; x < waf.getSize().getX(); x++) {
        // TODO: Draw
      }
    }
  }
}