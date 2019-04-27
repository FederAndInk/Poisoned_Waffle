package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.Coord;
import model.Game;
import model.PlayerType;
import model.Waffle;

/**
 * App
 */
public class App extends Application implements Observer {
  Game game;
  GridPane gridPane;
  Image image1;

  int scoreHeight = 50;

  @Override
  public void init() throws Exception {
    super.init();
    game = new Game();
    gridPane = new GridPane();
    image1 = new Image("view/waffleSquare.png", 100, 100, false, false);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    // TODO: when we know p1 and p2:
    game.begin(PlayerType.USER, PlayerType.USER, new Coord(10, 20));

    // TODO: UI menu
    // TODO: UI game
    primaryStage.setTitle("poizonu wafffffffffffffeulu");
    primaryStage.setFullScreen(false);
    VBox vbox = new VBox();
    HBox hbox = new HBox();
    Label p1 = new Label("player 1");
    Label p2 = new Label("player 2");
    Label emptyLabel = new Label(" ");
    p1.setAlignment(Pos.CENTER);
    p1.setStyle("-fx-border-color:yellow; -fx-background-color: red;");
    hbox.setMaxHeight(scoreHeight);
    hbox.setMinHeight(scoreHeight);
    p2.setAlignment(Pos.CENTER);
    p2.setStyle("-fx-border-color:yellow; -fx-background-color: red;");
    hbox.getChildren().addAll(p1, emptyLabel, p2);
    HBox.setHgrow(emptyLabel, Priority.ALWAYS);
    emptyLabel.setMaxWidth(Double.MAX_VALUE);
    vbox.getChildren().addAll(gridPane, hbox);
    VBox.setVgrow(gridPane, Priority.ALWAYS);
    gridPane.setMaxWidth(Double.MAX_VALUE);
    gridPane.setMaxHeight(Double.MAX_VALUE);
    // HBox.setHgrow(gridPane, Priority.ALWAYS);
    // Button button2 = new Button("Remove ");
    // hbox.getChildren().addAll(gridPane, button2);
    Scene s = new Scene(vbox);
    primaryStage.setScene(s);
    primaryStage.sizeToScene();

    primaryStage.show();
    primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
      Pair<Number, Number> wh = new Pair<>(newVal, primaryStage.getHeight());
      update(game.getWaffle(), wh);
    });
    primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
      Pair<Number, Number> wh = new Pair<>(primaryStage.getWidth(), newVal);
      update(game.getWaffle(), wh);
    });
    Pair<Number, Number> wh = new Pair<>(primaryStage.getWidth(), primaryStage.getHeight());
    // update(game.getWaffle(), wh);
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof Waffle && arg instanceof Pair) {
      Waffle waf = (Waffle) o;
      draw(waf, (Pair<Number, Number>) arg);
    }
  }

  private void draw(Waffle waf, Pair<Number, Number> pair) {
    Vector<ColumnConstraints> vect = new Vector<ColumnConstraints>();
    Vector<RowConstraints> vect2 = new Vector<RowConstraints>();
    double squareSize = 0;
    if (((double) pair.getValue() - scoreHeight) / (waf.getSize().getX() + 1) >= (double) pair.getKey()
        / (waf.getSize().getY() + 1)) {
      squareSize = (double) pair.getKey() / (waf.getSize().getY() + 1);
    } else {
      squareSize = ((double) pair.getValue() - scoreHeight) / (waf.getSize().getX() + 1);
    }
    for (int i = 0; i < waf.getSize().getY(); i++) {
      ColumnConstraints col = new ColumnConstraints();
      col.setMaxWidth(squareSize);
      col.setMinWidth(squareSize);
      // col.setPercentWidth(100.0 / (double) n.l);
      vect.add(col);
    }
    for (int i = 0; i < waf.getSize().getX(); i++) {
      RowConstraints col = new RowConstraints();
      col.setMaxHeight(squareSize);
      col.setMinHeight(squareSize);
      // col.setPercentHeight(100.0 / (double) n.c);
      vect2.add(col);
    }
    for (int y = 0; y < waf.getSize().getX(); y++) {
      for (int x = 0; x < waf.getSize().getY(); x++) {
        ImageView iv = new ImageView(image1);
        Pane pane = new Pane(iv);
        iv.setFitHeight(squareSize);
        iv.setFitWidth(squareSize);
        final int col = x;
        final int row = y;
        pane.setOnMouseEntered(e -> {
          System.out.printf("Mouse entered cell [%d, %d]%n", col, row);
        });
        pane.setOnMouseClicked(e -> {
          System.out.printf("Mouse clicked cell [%d, %d]%n", col, row);
        });
        System.out.println("added " + x + "," + y);
        gridPane.add(pane, x, y);
      }
    }
    gridPane.getColumnConstraints().setAll(vect);
    gridPane.getRowConstraints().setAll(vect2);
    gridPane.setGridLinesVisible(true);
  }
}