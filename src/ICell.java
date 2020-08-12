// ----------------------------------------------------------------------------------------------//
//      CS 2510 | Assignment 9 (Flood It World)                                                  //
//                                                                                               //
//      Cell.java                                                                                //
//      Made by Oleksandr Litus & Iryna Soloviava                                                //
// ----------------------------------------------------------------------------------------------//


/* ======================================== IMPORT ============================================= */
import java.awt.Color;
import javalib.worldimages.*;


/* ==================================== CELL INTERFACE ========================================= */
// to represent a cell
interface ICell {

  // to create an image of the cell
  WorldImage image();

  // ...
  void changeColorTo(Cell that);

  // ...
  boolean sameColor(ICell that);

  // ...
  boolean sameColorAsCell(Cell that);

  // ...
  void flood();
}



/* ========================================= CELL ============================================== */
// to represent a single square of the game area
class Cell implements ICell {

  /* ============== FIELDS ============================= */
  // in logical coordinates, with the origin at the top-left corner of the screen
  int x;
  int y;
  Color color;
  boolean flooded;

  // the four adjacent cells to this one
  ICell left;
  ICell top;
  ICell right;
  ICell bottom;



  /* ============== CONSTRUCTORS ======================= */
  // basic constructor
  Cell(int x, int y, Color color, boolean flooded,
       ICell left, ICell top, ICell right, ICell bottom) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.flooded = flooded;
    this.left = left;
    this.top = top;
    this.right = right;
    this.bottom = bottom;
  }

  // constructor where all adjacent cells are null
  Cell(int x, int y, Color color, boolean flooded) {
    this(x, y, color, flooded, new EmptyCell(), new EmptyCell(), new EmptyCell(), new EmptyCell());
  }



  /* ============== METHODS ============================ */
  // image to represent a cell
  public WorldImage image() {

    int size = Settings.CELL_SIZE;
    int shadowSize = size / 6;

    // image to represent a bottom shadow without corner
    WorldImage bottomShadowBlock = new RectangleImage(size - shadowSize, shadowSize,
            OutlineMode.SOLID, this.color.darker().darker());

    // image to represent a bottom shadow corner
    WorldImage bottomShadowCorner = new TriangleImage(
            new Posn(0, 0),
            new Posn(0, shadowSize),
            new Posn(shadowSize, shadowSize),
            OutlineMode.SOLID, this.color.darker().darker());

    // image to represent a bottom shadow
    WorldImage bottomShadow = new BesideImage(bottomShadowBlock, bottomShadowCorner);

    // image to represent a right shadow
    WorldImage rightShadow = new RectangleImage(shadowSize, size,
            OutlineMode.SOLID, this.color.darker());

    // image to represent a full shadow
    WorldImage shadow = new OverlayOffsetAlign(AlignModeX.RIGHT, AlignModeY.BOTTOM,
            bottomShadow, 0, 0, rightShadow);

    // image to represent a cell
    WorldImage cell = new RectangleImage(size, size, OutlineMode.SOLID, this.color);

    // returns shadow placed on top of the cell
    return new OverlayImage(shadow, cell);
  }

  // ...
  public void changeColorTo(Cell that) {
    this.color = that.color;
  }

  // ...
  public boolean sameColor(ICell that) {
    return that.sameColorAsCell(this);
  }

  // ...
  public boolean sameColorAsCell(Cell that) {
    return this.color.equals(that.color);
  }

  // ...
  boolean inAnimation(int level) {
    return this.x + this.y == level;
  }

  // ...
  void floodAround(Cell that) {

    // ...
    if (that.sameColor(this.left)) {
      this.left.flood();
    }

    // ...
    if (that.sameColor(this.top)) {
      this.top.flood();
    }

    // ...
    if (that.sameColor(this.right)) {
      this.right.flood();
    }

    // ...
    if (that.sameColor(this.bottom)) {
      this.bottom.flood();
    }
  }

  // ...
  public void flood() {
    this.flooded = true;
  }
}



/* ====================================== EMPTY CELL =========================================== */
// to represent an empty cell at the border of the grid
class EmptyCell implements ICell {


  /* ============== CONSTRUCTORS ======================= */
  EmptyCell() { }


  /* ============== METHODS ============================ */
  // empty cell is represented by an empty image
  public WorldImage image() {
    return new EmptyImage();
  }

  // ...
  public void changeColorTo(Cell that) {
    // do nothing
  }

  // ...
  public boolean sameColor(ICell that) {
    return false;
  }

  // ...
  public boolean sameColorAsCell(Cell that) {
    return false;
  }

  // ...
  public void flood() {
    // do nothing
  }
}
