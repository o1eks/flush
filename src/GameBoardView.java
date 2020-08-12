import javalib.worldimages.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

// ...
class GameBoardView extends AView {

  // ...
  ArrayList<Cell> board;
  int gameBoardSize;
  Cell chosenCell;

  // ...
  int animationDiagonal;


  // ...
  GameBoardView(int width, int height, int topMargin, int bottomMargin, int rightMargin,
                int leftMargin,
                Color backgroundColor, Color textColor, int textSize,
                ArrayList<Cell> board, int gameBoardSize) {
    super(width, height, topMargin, bottomMargin, rightMargin, leftMargin, backgroundColor,
            textColor, textSize);
    this.board = board;
    this.gameBoardSize = gameBoardSize;
  }

  // ...
  GameBoardView(int gameBoardSize, ArrayList<Color> colors, Random rand) {
    this(0, 0, 0, 0, 0, 0,
            Settings.BLANK_COLOR, Settings.BLANK_COLOR, 12, null, gameBoardSize);
    this.width = Settings.CELL_SIZE * this.gameBoardSize + Settings.MARGIN * 2;
    this.height = Settings.CELL_SIZE * this.gameBoardSize + Settings.MARGIN * 2;
    this.board = new ArrayList<>(gameBoardSize * gameBoardSize);
    this.createGrid(colors, rand);
    this.linkGrid();
    this.initializeBoard();
  }

  // ...
  GameBoardView(int gameBoardSize, ArrayList<Color> colors, Random rand, boolean linked) {
    this(0, 0, 0, 0, 0, 0,
            Settings.BLANK_COLOR, Settings.BLANK_COLOR, 12, null, gameBoardSize);
    this.gameBoardSize = gameBoardSize;
    this.board = new ArrayList<>(gameBoardSize * gameBoardSize);
    this.createGrid(colors, rand);
  }


  // creates the grid for the game with specified parameters
  private void createGrid(ArrayList<Color> colors, Random rand) {

    // iterate throw the rows of the grid
    for (int y = 0; y < this.gameBoardSize; y++) {

      // iterate throw the columns of the row
      for (int x = 0; x < this.gameBoardSize; x++) {

        // getting random color from the game colors
        Color randColor = colors.get(rand.nextInt(colors.size()));

        // add new cell to the board with x and y as coordinates, and randomly chosen color
        this.board.add(new Cell(x, y, randColor, false));
      }
    }
  }

  // links all the cells to each other
  private void linkGrid() {

    int size = this.gameBoardSize;

    // iterate throw the rows of the grid
    for (int y = 0; y < size; y++) {

      // iterate throw the columns of the row
      for (int x = 0; x < size; x++) {

        int index = y * size + x;
        Cell cell = this.board.get(index);

        // if the cell is in the first column, than it has empty cell to the left
        // otherwise it has the cell with index minus one
        if (x == 0) {
          cell.left = new EmptyCell();
        } else {
          cell.left = this.board.get(index - 1);
        }

        // if the cell is in the last column, than it has empty cell to the right
        // otherwise it has the cell with index plus one
        if (x == size - 1) {
          cell.right = new EmptyCell();
        } else {
          cell.right = this.board.get(index + 1);
        }

        // if the cell is in the first row, than it has empty cell to the top
        // otherwise it has the cell with index minus size
        if (y == 0) {
          cell.top = new EmptyCell();
        } else {
          cell.top = this.board.get(index - size);
        }

        // if the cell is in the last row, than it has empty cell to the bottom
        // otherwise it has the cell with index plus size
        if (y == size - 1) {
          cell.bottom = new EmptyCell();
        } else {
          cell.bottom = this.board.get(index + size);
        }
      }
    }
  }

  // ...
  void initializeBoard() {
    this.chosenCell = this.board.get(0);
    this.chosenCell.flood();
    this.animationDiagonal = 0;
    this.flood();
  }

  // ...
  public void update() {
    // ...
    if (this.animationDiagonal < this.gameBoardSize * 2) {
      this.animate();
    }

    this.animationDiagonal = this.animationDiagonal + 1;
    this.flood();
  }

  // ...
  void flood() {

    // ...
    for (Cell cell : this.board) {
      if (cell.flooded) {
        cell.floodAround(this.chosenCell);
      }
    }
  }

  // ...
  void animate() {

    // ...
    for (Cell cell : this.board) {
      if (cell.flooded && cell.inAnimation(this.animationDiagonal)) {
        cell.changeColorTo(this.chosenCell);
      }
    }
  }







  // creates an image of the game board
  public WorldImage makeViewImage() {

    int canvasSize = (this.gameBoardSize * Settings.CELL_SIZE) + (Settings.MARGIN * 2);

    // image of the board canvas
    WorldImage gridCanvas = new RectangleImage(
            canvasSize, canvasSize,
            OutlineMode.OUTLINE,
            Settings.BLANK_COLOR);

    // returns grid image placed on the canvas
    return new OverlayImage(this.gridImage(), gridCanvas);
  }

  // creates an image of the game grid
  public WorldImage gridImage() {

    WorldImage gridImage = new EmptyImage();
    WorldImage rowImage;
    int size = this.gameBoardSize;

    // iterate throw the rows of the grid
    for (int y = 0; y < size; y++) {

      // reset the row image
      rowImage = new EmptyImage();

      // iterate throw the columns of the grid
      for (int x = 0; x < size; x++) {

        int index = y * size + x;
        Cell cell = this.board.get(index);

        // places each cell next to the rest of them
        rowImage = new OverlayOffsetAlign(
                AlignModeX.RIGHT, AlignModeY.MIDDLE,
                rowImage,
                Settings.CELL_SIZE, 0,
                cell.image());
      }

      // places each row underneath the others
      gridImage = new OverlayOffsetAlign(
              AlignModeX.CENTER, AlignModeY.BOTTOM,
              gridImage,
              0, Settings.CELL_SIZE,
              rowImage);
    }

    return gridImage;
  }

  // ...
  public void onMouseClicked(Posn pos) {

    // ...
    int cellX = pos.x / Settings.CELL_SIZE;

    // ...
    int cellY = pos.y / Settings.CELL_SIZE;

    // ...
    int index = cellY * this.gameBoardSize + cellX;

    // ...
    this.chosenCell = this.board.get(index);

    // ...
    this.animationDiagonal = 0;

    // ...
    this.flood();

    //throw new IllegalArgumentException(Integer.toString(index));
  }
}
