import java.util.ArrayList;
import javalib.impworld.*;
import java.awt.Color;
import java.util.Random;
import javalib.worldimages.*;

// ...
class Game extends World {

  // ...
  int width;
  int height;

  // ...
  IView titleBarView;
  IView infoBarView;
  IView gameBoardView;
  IView statusBarView;

  // ...
  Random rand;
  ArrayList<Color> colors;
  int gameBoardSize;



  // basic constructor
  Game(int gameBoardSize, int numColors, boolean useRandomColors,
       boolean useRandomSeed, int randomSeed) {

    // if the provided size of the game board is less then 0, throw an error
    if (gameBoardSize <= 0) {
      throw new IllegalArgumentException("Game board size should be at least 1!");
    } else {
      this.gameBoardSize = gameBoardSize;
    }

    // if number of colors provided is less then 0, throw an error
    if (numColors <= 0) {
      throw new IllegalArgumentException("Number of colors should be at least 1!");
    }

    // if colors are not random and number of colors provided is more then 8, throw an error
    if (!useRandomColors && numColors > 8) {
      throw new IllegalArgumentException("If colors are not random, "
              + "number of colors should not be more than 8!");
    }

    // if seed is used then create random object with that seed
    if (useRandomSeed) {
      this.rand = new Random(randomSeed);
    } else {
      this.rand = new Random();
    }

    // if random colors are turned on get colors from random pool
    if (useRandomColors) {
      this.colors = this.colorsFromRandomPool(numColors);
    } else {
      this.colors = this.colorsFromStandardPool(numColors);
    }

    this.width = (gameBoardSize * Settings.CELL_SIZE) + Settings.MARGIN * 2;

    // setting up height of the game
    this.height = Settings.TITLE_BAR_HEIGHT
            + Settings.INFO_BAR_HEIGHT
            + (gameBoardSize * Settings.CELL_SIZE)
            + (Settings.MARGIN * 2)
            + Settings.STATUS_BAR_HEIGHT;


    // initializing views
    this.gameBoardView = new GameBoardView(gameBoardSize, this.colors, this.rand);
    this.titleBarView = new TitleBarView(this.width);
    this.infoBarView = new InfoBarView(this.width);
    this.statusBarView = new StatusBarView(gameBoardSize, numColors, this.width);
  }

  // to create a game with specified settings
  Game() {
    this(Settings.GRID_SIZE,
            Settings.NUMBER_OF_COLORS,
            Settings.RANDOM_COLORS,
            Settings.USE_SEED,
            Settings.RANDOM_SEED);
  }


  // creates an array of random colors
  private ArrayList<Color> colorsFromRandomPool(int numColors) {

    ArrayList<Color> randomColors = new ArrayList<>(numColors);

    for (int i = 0; i < numColors; i++) {
      Color color = new Color(
              this.rand.nextInt(256),
              this.rand.nextInt(256),
              this.rand.nextInt(256));

      randomColors.add(color);
    }

    return randomColors;
  }

  // creates an array of colors from standard pool
  private ArrayList<Color> colorsFromStandardPool(int numColors) {

    ArrayList<Color> standardColors = new ArrayList<>(numColors);

    for (int i = 0; i < numColors; i++) {
      standardColors.add(Settings.COLOR_POOL.get(i));
    }

    return standardColors;
  }

  // updates all the views in the game
  public void onTick() {
    this.titleBarView.update();
    this.infoBarView.update();
    this.gameBoardView.update();
    this.statusBarView.update();
  }

  // handles the scene of the game
  public WorldScene makeScene() {
    Posn gameCenter = new Posn(this.width / 2, this.height / 2);

    WorldScene gameScene = new WorldScene(this.width, this.height);

    gameScene.placeImageXY(
            this.gameBackgroundImage(Settings.GAME_BACKGROUND_COLOR),
            gameCenter.x, gameCenter.y);

    gameScene.placeImageXY(
            this.gameImage(),
            gameCenter.x, gameCenter.y);

    return gameScene;
  }

  // creates an image of game's background
  private WorldImage gameBackgroundImage(Color color) {
    return new RectangleImage(
            this.width,
            this.height,
            OutlineMode.SOLID,
            color);
  }

  // creates an image of the game
  private WorldImage gameImage() {
    return new AboveImage(
            this.titleBarView.makeViewImage(),
            this.infoBarView.makeViewImage(),
            this.gameBoardView.makeViewImage(),
            this.statusBarView.makeViewImage());
  }

  // to handle key events in the game
  public void onKeyEvent(String key) {
    // when "r" is pressed resets the game
    if (key.equals("r")) {
      this.resetGame();
    }
  }

  // to handle mouse click events in the game
  public void onMouseClicked(Posn pos) {

    // ...
    boolean gameBoardViewClicked = (pos.x > Settings.MARGIN)
            && (pos.x < ((this.gameBoardSize * Settings.CELL_SIZE) + Settings.MARGIN))
            && (pos.y > (Settings.TITLE_BAR_HEIGHT + Settings.INFO_BAR_HEIGHT + Settings.MARGIN))
            && (pos.y < Settings.TITLE_BAR_HEIGHT + Settings.INFO_BAR_HEIGHT + Settings.MARGIN
            + (this.gameBoardSize * Settings.CELL_SIZE));

    // ...
    if (gameBoardViewClicked) {
      // ...
      int gameBoardX = pos.x - Settings.MARGIN;

      // ...
      int gameBoardY = pos.y - Settings.TITLE_BAR_HEIGHT - Settings.INFO_BAR_HEIGHT
              - Settings.MARGIN;

      // ...
      Posn gameBoardPosition = new Posn(gameBoardX, gameBoardY);

      // ...
      this.gameBoardView.onMouseClicked(gameBoardPosition);


    }
  }

  // resets the game with specified in settings conditions
  void resetGame() {

    // if seed is used then create random object with that seed
    if (Settings.USE_SEED) {
      this.rand = new Random(Settings.RANDOM_SEED);
    } else {
      this.rand = new Random();
    }

    // if random colors are turned on get colors from random pool
    if (Settings.RANDOM_COLORS) {
      this.colors = this.colorsFromRandomPool(this.colors.size());
    } else {
      this.colors = this.colorsFromStandardPool(this.colors.size());
    }

    // resets the board of the game with new colors and rand
    this.gameBoardView = new GameBoardView(Settings.GRID_SIZE, this.colors, this.rand);
  }
}

