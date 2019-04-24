package view;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    primaryStage.setTitle("poizoin wafffffffffffffeulu");
    primaryStage.setFullScreen(false);
    GridPane gridpane = new GridPane();
    update(game.getWaffle(), gridpane);
    HBox hbox = new HBox();
    hbox.getChildren().add(gridpane);
    Scene s = new Scene(hbox);
    primaryStage.setScene(s);
    primaryStage.sizeToScene();

    primaryStage.show();
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof Waffle && arg instanceof GridPane) {
      Waffle waf = (Waffle) o;
      draw(waf, (GridPane) arg);
    }
  }

  private void draw(Waffle waf, GridPane gridPane) {
    for (int y = 0; y < waf.getSize().getY(); y++) {
      for (int x = 0; x < waf.getSize().getX(); x++) {
        Image image1 = new Image("waffleSquare.jpeg", 100, 100, true, true);
        ImageView iv = new ImageView(image1);
        gridPane.add(iv, x, y);
      }
    }
  }
}