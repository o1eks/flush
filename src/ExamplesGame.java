// ----------------------------------------------------------------------------------------------//
//      CS 2510 | Assignment 9 (Flood It World)                                                  //
//                                                                                               //
//      ExamplesGame.java                                                                        //
//      Made by Oleksandr Litus & Iryna Soloviava                                                //
// ----------------------------------------------------------------------------------------------//


/* ======================================== IMPORT ============================================= */
import tester.*;

/*
      ENHANCEMENTS

      To-Do:
      - Show current settings
      - Light up the area that is currently at play
      - Add Authors
      - Added Exceptions
      - Show colors in the game below, let people click them instead
      - add scoreboard
      - add cool background like checkers
      - add time
      - let user pick the colors
      - count how many flooded cells are in the game
      - create increasing levels
      - let person choose the game mode inside the game
      - have scoreboard
      - let player draw structure to block
      - pixel art mode

      Done:
      - tick-rate depends on the grid size (so animation is always ar desired rate)
      - cells look like tiles
      - animation of the tital
      - random colors and standart
      - file with settings



      -- CHange to IView style
*/




/* ======================================  BIG-BANG ==========================================  */
// to run the game
class StartGame {
  // to run the game
  void testBigBang(Tester t) {
    Game game = new Game();
    game.bigBang(Settings.WORLD_WIDTH, Settings.WORLD_HEIGHT, Settings.TICK_RATE);
  }
}



/* =================================== EXAMPLES & TESTS ======================================== */
// to represent examples and tests in the game
// to run the big-bang
//class ExamplesGame {
//
//  /* ============ EXAMPLES =================================================================== */
//  // ------------ ICell Examples ------------- //
//  ICell emptyCell = new EmptyCell();
//  ICell cell0 = new Cell(0, 0, Color.MAGENTA, true);
//  ICell cell1 = new Cell(0, 0, Color.GREEN, false);
//  ICell cell2 = new Cell(0, 0, Color.GREEN, false);
//  ICell cell3 = new Cell(0, 0, Color.GREEN, false);
//  ICell cell4 = new Cell(0, 0, Color.BLUE, false);
//  ICell cell5 = new Cell(0, 0, Color.RED, false);
//  ICell cell6 = new Cell(0, 0, Color.GREEN, false);
//  ICell cell7 = new Cell(0, 0, Color.BLUE, false);
//  ICell cell8 = new Cell(0, 0, Color.MAGENTA, false);
//
//
//  // ------------ IBar Examples ------------- //
//  IBar titleBar = new TitleBarView(300);
//  IBar titleBar3 = new TitleBarView(300);
//  ABar titleBarA = new TitleBarView(300);
//  ABar titleBarA2 = new TitleBarView(300);
//  IBar titleBarGame = new TitleBarView(300);
//  IBar titleBar1With1Step = new TitleBarView(300, "WEIRD FLOOD", 0.5, -0.5, 0.5, -0.5);
//  IBar titleBar1With5Step = new TitleBar("WEIRD FLOOD", 2.5, -2.5, 0.5, -0.5, 300);
//  IBar titleBar1With6Step = new TitleBar("WEIRD FLOOD", 3.0, -3.0, 0.5, -0.5, 300);
//  IBar titleBar2With4Step = new TitleBar("WEIRD FLOOD", 2.0, -2.0, 0.5, -0.5, 300);
//  IBar titleBar2With1Step = new TitleBar("WEIRD FLOOD", 0.5, -0.5, 0.5, -0.5, 300);
//  IBar titleBar3With2Step = new TitleBar("WEIRD FLOOD", 1.0, -1.0, 0.5, -0.5, 300);
//  IBar titleBar3With3Step = new TitleBar("WEIRD FLOOD", 1.5, -1.5, 0.5, -0.5, 300);
//  IBar infoBar = new InfoBar(0, 100, 300);
//  IBar infoBar2 = new InfoBar(1, 4, 300);
//  IBar infoBar3 = new InfoBar(99, 99, 300);
//  ABar infoBarA = new InfoBar(300);
//  ABar infoBarA2 = new InfoBar(300);
//  IBar statusBar = new StatusBar(3, 4, 300);
//  IBar statusBar2 = new StatusBar(1, 1, 150);
//  IBar statusBar3 = new StatusBar(40, 8, 200);
//  ABar statusBarA = new StatusBar(3, 4, 300);
//  ABar statusBarA2 = new StatusBar(3, 4, 300);
//
//
//  // ------------ IBoard Examples ------------- //
//  Board board1 = new Board(3,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//  Board board2 = new Board(1,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//  Board board3 = new Board(20,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//
//  Board board1Unlinked = new Board(3,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//  Board board2Unlinked = new Board(1,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//  Board board3Unlinked = new Board(20,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//
//  Board board1Unlinked2 = new Board(3,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//  Board board2Unlinked2 = new Board(1,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//  Board board3Unlinked2 = new Board(20,
//          Settings.COLOR_POOL, new Random(Settings.RANDOM_SEED));
//
//
//  // ------------ FloodItWorld Examples ------------- //
//  FloodItWorld game1 = new FloodItWorld(3, 4, true,
//          Settings.RANDOM_SEED, false);
//
//  FloodItWorld game2 = new FloodItWorld(4, 8, false,
//          44444, false);
//
//  FloodItWorld game3 = new FloodItWorld(1, 1, true,
//          55552223, false);
//
//  FloodItWorld game1Rand = new FloodItWorld(3, 4, true,
//          Settings.RANDOM_SEED, true);
//
//  FloodItWorld game2Rand = new FloodItWorld(4, 14, true,
//          44444, true);
//
//  FloodItWorld game3Rand = new FloodItWorld(1, 1, true,
//          55552223, true);
//
//
//
//
//
//  /* ============ TESTS ====================================================================== */
//  // ------------ ICell Tests ------------- //
//  // test for image() method in Cell class
//  void testImageCell(Tester t) {
//
//    int size = Settings.CELL_SIZE;
//    int shadowSize = size / 6;
//
//    WorldImage bottomShadowBlock = new RectangleImage(size - shadowSize, shadowSize,
//            OutlineMode.SOLID, Color.GREEN.darker().darker());
//
//    WorldImage bottomShadowCorner = new TriangleImage(
//            new Posn(0, 0),
//            new Posn(0, shadowSize),
//            new Posn(shadowSize, shadowSize),
//            OutlineMode.SOLID, Color.GREEN.darker().darker());
//
//    WorldImage bottomShadow = new BesideImage(bottomShadowBlock, bottomShadowCorner);
//
//    WorldImage rightShadow = new RectangleImage(shadowSize, size,
//            OutlineMode.SOLID, Color.GREEN.darker());
//
//    WorldImage shadow = new OverlayOffsetAlign(AlignModeX.RIGHT, AlignModeY.BOTTOM,
//            bottomShadow, 0, 0, rightShadow);
//
//    WorldImage cell = new RectangleImage(size, size, OutlineMode.SOLID, Color.GREEN);
//
//    // returns shadow placed on top of the cell
//    WorldImage cell1Image =  new OverlayImage(shadow, cell);
//
//
//    t.checkExpect(this.cell1.image(), cell1Image);
//
//
//    int size2 = Settings.CELL_SIZE;
//    int shadowSize2 = size2 / 6;
//
//    WorldImage bottomShadowBlock2 = new RectangleImage(size2 - shadowSize2, shadowSize2,
//            OutlineMode.SOLID, Color.RED.darker().darker());
//
//    WorldImage bottomShadowCorner2 = new TriangleImage(
//            new Posn(0, 0),
//            new Posn(0, shadowSize2),
//            new Posn(shadowSize2, shadowSize2),
//            OutlineMode.SOLID, Color.RED.darker().darker());
//
//    WorldImage bottomShadow2 = new BesideImage(bottomShadowBlock2, bottomShadowCorner2);
//
//    WorldImage rightShadow2 = new RectangleImage(shadowSize2, size2,
//            OutlineMode.SOLID, Color.RED.darker());
//
//    WorldImage shadow2 = new OverlayOffsetAlign(AlignModeX.RIGHT, AlignModeY.BOTTOM,
//            bottomShadow2, 0, 0, rightShadow2);
//
//    WorldImage cell2 = new RectangleImage(size2, size2, OutlineMode.SOLID, Color.RED);
//
//    // returns shadow placed on top of the cell
//    WorldImage cell2Image =  new OverlayImage(shadow2, cell2);
//
//
//    t.checkExpect(this.cell5.image(), cell2Image);
//
//
//    int size3 = Settings.CELL_SIZE;
//    int shadowSize3 = size3 / 6;
//
//    WorldImage bottomShadowBlock3 = new RectangleImage(size3 - shadowSize3, shadowSize3,
//            OutlineMode.SOLID, Color.MAGENTA.darker().darker());
//
//    WorldImage bottomShadowCorner3 = new TriangleImage(
//            new Posn(0, 0),
//            new Posn(0, shadowSize3),
//            new Posn(shadowSize3, shadowSize3),
//            OutlineMode.SOLID, Color.MAGENTA.darker().darker());
//
//    WorldImage bottomShadow3 = new BesideImage(bottomShadowBlock3, bottomShadowCorner3);
//
//    WorldImage rightShadow3 = new RectangleImage(shadowSize, size3,
//            OutlineMode.SOLID, Color.MAGENTA.darker());
//
//    WorldImage shadow3 = new OverlayOffsetAlign(AlignModeX.RIGHT, AlignModeY.BOTTOM,
//            bottomShadow3, 0, 0, rightShadow3);
//
//    WorldImage cell3 = new RectangleImage(size3, size3, OutlineMode.SOLID, Color.MAGENTA);
//
//    // returns shadow placed on top of the cell
//    WorldImage cell3Image =  new OverlayImage(shadow3, cell3);
//
//
//    t.checkExpect(this.cell8.image(), cell3Image);
//  }
//
//  // test for image() method in EmptyCell class
//  void testImageEmptyCell(Tester t) {
//    t.checkExpect(this.emptyCell.image(), new EmptyImage());
//  }
//
//
//
//
//
//  // ------------ IBar Tests ------------- //
//  // test for update() method in ABar class
//  void testUpdateABar(Tester t) {
//
//    ABar infoBarA2Copy = new InfoBar(300);
//    ABar statusBarA2Copy = new StatusBar(3, 4, 300);
//
//    infoBarA2Copy.update();
//    t.checkExpect(this.infoBarA2, infoBarA2Copy);
//
//    statusBarA2Copy.update();
//    t.checkExpect(this.statusBarA2, statusBarA2Copy);
//  }
//
//  // test for canvas() method in ABar class
//  void testCanvasABar(Tester t) {
//
//    WorldImage titleBarACanvas = new RectangleImage(
//            titleBarA.width,
//            titleBarA.height,
//            OutlineMode.SOLID,
//            titleBarA.background);
//    t.checkExpect(this.titleBarA.canvas(), titleBarACanvas);
//
//
//    WorldImage titleBarACanvas2 = new RectangleImage(
//            infoBarA.width,
//            infoBarA.height,
//            OutlineMode.SOLID,
//            infoBarA.background);
//    t.checkExpect(this.infoBarA.canvas(), titleBarACanvas2);
//
//
//    WorldImage titleBarACanvas3 = new RectangleImage(
//            statusBarA.width,
//            statusBarA.height,
//            OutlineMode.SOLID,
//            statusBarA.background);
//    t.checkExpect(this.statusBarA.canvas(), titleBarACanvas3);
//  }
//
//  // test for update() method in TitleBar class
//  void testUpdateTitleBar(Tester t) {
//
//    t.checkExpect(this.titleBar, this.titleBar);
//
//    this.titleBar.update();
//
//    t.checkExpect(this.titleBar, this.titleBar1With1Step);
//
//    this.titleBar.update();
//    this.titleBar.update();
//    this.titleBar.update();
//    this.titleBar.update();
//    t.checkExpect(this.titleBar, this.titleBar1With5Step);
//
//    this.titleBar.update();
//
//    t.checkExpect(this.titleBar, this.titleBar1With6Step);
//
//  }
//
//  // test for image() method in TitleBar class
//  void testImageTitleBar(Tester t) {
//
//    WorldImage titleImage = new OverlayOffsetImage(
//            new TextImage("WEIRD FLOOD", Settings.TITLE_SIZE, Settings.TITLE_COLOR),
//            0, 0,
//            new TextImage("WEIRD FLOOD", Settings.TITLE_SIZE, Settings.TITLE_COLOR.darker()));
//
//    WorldImage titleBarImage = new OverlayImage(titleImage, titleBar3.canvas());
//    t.checkExpect(this.titleBar3.image(), titleBarImage);
//
//
//    WorldImage titleImage2 = new OverlayOffsetImage(
//            new TextImage("WEIRD FLOOD", Settings.TITLE_SIZE, Settings.TITLE_COLOR),
//            0.5, -0.5,
//            new TextImage("WEIRD FLOOD", Settings.TITLE_SIZE, Settings.TITLE_COLOR.darker()));
//
//    WorldImage titleBarImage2 = new OverlayImage(titleImage2, titleBar1With1Step.canvas());
//    t.checkExpect(this.titleBar1With1Step.image(), titleBarImage2);
//
//
//    WorldImage titleImage3 = new OverlayOffsetImage(
//            new TextImage("WEIRD FLOOD", Settings.TITLE_SIZE, Settings.TITLE_COLOR),
//            1.0, -1.0,
//            new TextImage("WEIRD FLOOD", Settings.TITLE_SIZE, Settings.TITLE_COLOR.darker()));
//
//    WorldImage titleBarImage3 = new OverlayImage(titleImage3, titleBar3With2Step.canvas());
//    t.checkExpect(this.titleBar3With2Step.image(), titleBarImage3);
//
//  }
//
//  // test for image() method in InfoBar class
//  void testImageInfoBar(Tester t) {
//
//    String currentStepStr = Integer.toString(0);
//    String totalStepsStr = Integer.toString(100);
//
//
//    WorldImage scoreImage = new TextImage(
//            "Score: " + currentStepStr + "/" + totalStepsStr,
//            Settings.INFO_SIZE,
//            Settings.INFO_COLOR);
//
//    // returns the information image places on the canvas of bars size
//    WorldImage infoBarImage = new OverlayImage(scoreImage, infoBar.canvas());
//
//    t.checkExpect(this.infoBar.image(), infoBarImage);
//
//
//
//    String currentStepStr2 = Integer.toString(1);
//    String totalStepsStr2 = Integer.toString(4);
//
//
//    WorldImage scoreImage2 = new TextImage(
//            "Score: " + currentStepStr2 + "/" + totalStepsStr2,
//            Settings.INFO_SIZE,
//            Settings.INFO_COLOR);
//
//    // returns the information image places on the canvas of bars size
//    WorldImage infoBarImage2 = new OverlayImage(scoreImage2, infoBar2.canvas());
//
//    t.checkExpect(this.infoBar2.image(), infoBarImage2);
//
//
//
//    String currentStepStr3 = Integer.toString(99);
//    String totalStepsStr3 = Integer.toString(99);
//
//
//    WorldImage scoreImage3 = new TextImage(
//            "Score: " + currentStepStr3 + "/" + totalStepsStr3,
//            Settings.INFO_SIZE,
//            Settings.INFO_COLOR);
//
//    // returns the information image places on the canvas of bars size
//    WorldImage infoBarImage3 = new OverlayImage(scoreImage3, infoBar3.canvas());
//
//    t.checkExpect(this.infoBar3.image(), infoBarImage3);
//  }
//
//  // test for image() method in StatusBar class
//  void testImageStatusBar(Tester t) {
//
//    String gridSizeStr = Integer.toString(3);
//    String numColorsStr = Integer.toString(4);
//
//    WorldImage gridSizeImage = new TextImage(
//            "Size: " + gridSizeStr + "x" + gridSizeStr,
//            Settings.STATUS_SIZE,
//            Settings.STATUS_COLOR);
//
//    WorldImage numColorsImage = new TextImage(
//            "#Colors: " + numColorsStr,
//            Settings.STATUS_SIZE,
//            Settings.STATUS_COLOR);
//
//    WorldImage statusInfoImage = new OverlayOffsetAlign(
//            AlignModeX.RIGHT, AlignModeY.MIDDLE,
//            gridSizeImage,
//            numColorsImage.getWidth() + Settings.MARGIN, 0,
//            numColorsImage);
//
//    WorldImage statusBar = new OverlayImage(statusInfoImage, this.statusBar.canvas());
//    t.checkExpect(this.statusBar.image(), statusBar);
//
//
//    String gridSizeStr2 = Integer.toString(1);
//    String numColorsStr2 = Integer.toString(1);
//
//    WorldImage gridSizeImage2 = new TextImage(
//            "Size: " + gridSizeStr2 + "x" + gridSizeStr2,
//            Settings.STATUS_SIZE,
//            Settings.STATUS_COLOR);
//
//    WorldImage numColorsImage2 = new TextImage(
//            "#Colors: " + numColorsStr2,
//            Settings.STATUS_SIZE,
//            Settings.STATUS_COLOR);
//
//    WorldImage statusInfoImage2 = new OverlayOffsetAlign(
//            AlignModeX.RIGHT, AlignModeY.MIDDLE,
//            gridSizeImage2,
//            numColorsImage2.getWidth() + Settings.MARGIN, 0,
//            numColorsImage2);
//
//    WorldImage statusBar2 = new OverlayImage(statusInfoImage2, this.statusBar2.canvas());
//    t.checkExpect(this.statusBar2.image(), statusBar2);
//
//
//
//    String gridSizeStr3 = Integer.toString(40);
//    String numColorsStr3 = Integer.toString(8);
//
//    WorldImage gridSizeImage3 = new TextImage(
//            "Size: " + gridSizeStr3 + "x" + gridSizeStr3,
//            Settings.STATUS_SIZE,
//            Settings.STATUS_COLOR);
//
//    WorldImage numColorsImage3 = new TextImage(
//            "#Colors: " + numColorsStr3,
//            Settings.STATUS_SIZE,
//            Settings.STATUS_COLOR);
//
//    WorldImage statusInfoImage3 = new OverlayOffsetAlign(
//            AlignModeX.RIGHT, AlignModeY.MIDDLE,
//            gridSizeImage3,
//            numColorsImage3.getWidth() + Settings.MARGIN, 0,
//            numColorsImage3);
//
//    WorldImage statusBar3 = new OverlayImage(statusInfoImage3, this.statusBar3.canvas());
//    t.checkExpect(this.statusBar3.image(), statusBar3);
//
//  }
//
//
//
//  // ------------ IBoard Tests ------------- //
//  // test for createGrid() method in Board class
//  void testCreateGridBoard(Tester t) {
//
//    Random rand = new Random(Settings.RANDOM_SEED);
//
//    ArrayList<Cell> board1Answer = new ArrayList<>();
//
//    for (int y = 0; y < this.board1Unlinked.gridSize; y++) {
//      for (int x = 0; x < this.board1Unlinked.gridSize; x++) {
//        Color randColor = Settings.COLOR_POOL.get(rand.nextInt(Settings.COLOR_POOL.size()));
//        board1Answer.add(new Cell(x, y, randColor, false));
//      }
//    }
//
//    t.checkExpect(this.board1Unlinked.board, board1Answer);
//
//
//    Random rand2 = new Random(Settings.RANDOM_SEED);
//
//    ArrayList<Cell> board2Answer = new ArrayList<>();
//
//    for (int y = 0; y < this.board2Unlinked.gridSize; y++) {
//      for (int x = 0; x < this.board2Unlinked.gridSize; x++) {
//        Color randColor2 = Settings.COLOR_POOL.get(rand2.nextInt(Settings.COLOR_POOL.size()));
//        board2Answer.add(new Cell(x, y, randColor2, false));
//      }
//    }
//
//    t.checkExpect(this.board2Unlinked.board, board2Answer);
//
//
//
//    Random rand3 = new Random(Settings.RANDOM_SEED);
//
//    ArrayList<Cell> board3Answer = new ArrayList<>();
//
//    for (int y = 0; y < this.board3Unlinked.gridSize; y++) {
//      for (int x = 0; x < this.board3Unlinked.gridSize; x++) {
//        Color randColor3 = Settings.COLOR_POOL.get(rand3.nextInt(Settings.COLOR_POOL.size()));
//        board3Answer.add(new Cell(x, y, randColor3, false));
//      }
//    }
//
//    t.checkExpect(this.board3Unlinked.board, board3Answer);
//  }
//
//  // test for linkGrid() method in Board class
//  void testLinkGridBoard(Tester t) {
//    this.board1Unlinked2.linkGrid();
//    t.checkExpect(this.board1Unlinked2, this.board1);
//
//    this.board2Unlinked2.linkGrid();
//    t.checkExpect(this.board2Unlinked2, this.board2);
//
//    this.board3Unlinked2.linkGrid();
//    t.checkExpect(this.board3Unlinked2, this.board3);
//  }
//
//  // test for image() method in Board class
//  void testImageBoard(Tester t) {
//
//    int canvasSize = (this.board1.gridSize * Settings.CELL_SIZE) + (Settings.MARGIN * 2);
//
//    WorldImage gridCanvas = new RectangleImage(
//            canvasSize, canvasSize,
//            OutlineMode.OUTLINE,
//            Settings.BLANK_COLOR);
//
//    WorldImage board1Image = new OverlayImage(this.board1.gridImage(), gridCanvas);
//
//    t.checkExpect(this.board1.image(), board1Image);
//
//
//
//    int canvasSize2 = (this.board2.gridSize * Settings.CELL_SIZE) + (Settings.MARGIN * 2);
//
//    WorldImage gridCanvas2 = new RectangleImage(
//            canvasSize2, canvasSize2,
//            OutlineMode.OUTLINE,
//            Settings.BLANK_COLOR);
//
//    WorldImage board2Image = new OverlayImage(this.board2.gridImage(), gridCanvas2);
//
//    t.checkExpect(this.board2.image(), board2Image);
//
//
//
//
//    int canvasSize3 = (this.board3.gridSize * Settings.CELL_SIZE) + (Settings.MARGIN * 2);
//
//    WorldImage gridCanvas3 = new RectangleImage(
//            canvasSize3, canvasSize3,
//            OutlineMode.OUTLINE,
//            Settings.BLANK_COLOR);
//
//    WorldImage board3Image = new OverlayImage(this.board3.gridImage(), gridCanvas3);
//
//    t.checkExpect(this.board3.image(), board3Image);
//
//  }
//
//  // test for gridImage() method in Board class
//  void testGridImageBoard(Tester t) {
//
//    WorldImage gridImage = new EmptyImage();
//    WorldImage rowImage;
//    int size = this.board1.gridSize;
//
//    for (int y = 0; y < size; y++) {
//
//      rowImage = new EmptyImage();
//
//      for (int x = 0; x < size; x++) {
//
//        int index = y * size + x;
//        Cell cell = this.board1.board.get(index);
//
//        rowImage = new OverlayOffsetAlign(
//                AlignModeX.RIGHT, AlignModeY.MIDDLE,
//                rowImage,
//                Settings.CELL_SIZE, 0,
//                cell.image());
//      }
//
//      gridImage = new OverlayOffsetAlign(
//              AlignModeX.CENTER, AlignModeY.BOTTOM,
//              gridImage,
//              0, Settings.CELL_SIZE,
//              rowImage);
//    }
//
//    t.checkExpect(this.board1.gridImage(), gridImage);
//
//
//    WorldImage gridImage2 = new EmptyImage();
//    WorldImage rowImage2;
//    int size2 = this.board2.gridSize;
//
//    for (int y = 0; y < size2; y++) {
//
//      rowImage2 = new EmptyImage();
//
//      for (int x = 0; x < size2; x++) {
//
//        int index2 = y * size2 + x;
//        Cell cell2 = this.board2.board.get(index2);
//
//        rowImage2 = new OverlayOffsetAlign(
//                AlignModeX.RIGHT, AlignModeY.MIDDLE,
//                rowImage2,
//                Settings.CELL_SIZE, 0,
//                cell2.image());
//      }
//
//      gridImage2 = new OverlayOffsetAlign(
//              AlignModeX.CENTER, AlignModeY.BOTTOM,
//              gridImage2,
//              0, Settings.CELL_SIZE,
//              rowImage2);
//    }
//
//    t.checkExpect(this.board2.gridImage(), gridImage2);
//
//
//
//    WorldImage gridImage3 = new EmptyImage();
//    WorldImage rowImage3;
//    int size3 = this.board3.gridSize;
//
//    for (int y = 0; y < size3; y++) {
//
//      rowImage3 = new EmptyImage();
//
//      for (int x = 0; x < size3; x++) {
//
//        int index3 = y * size3 + x;
//        Cell cell3 = this.board3.board.get(index3);
//
//        rowImage3 = new OverlayOffsetAlign(
//                AlignModeX.RIGHT, AlignModeY.MIDDLE,
//                rowImage3,
//                Settings.CELL_SIZE, 0,
//                cell3.image());
//      }
//
//      gridImage3 = new OverlayOffsetAlign(
//              AlignModeX.CENTER, AlignModeY.BOTTOM,
//              gridImage3,
//              0, Settings.CELL_SIZE,
//              rowImage3);
//    }
//
//    t.checkExpect(this.board3.gridImage(), gridImage3);
//  }
//
//
//
//
//  // ------------ FloodItWorld Tests ------------- //
//  // test for Constructor Exceptions in FloodItWorld class
//  void testConstructorExceptionsFloodItWorld(Tester t) {
//    t.checkConstructorException(
//            new IllegalArgumentException("Grid size should be at least 1!"),
//            "FloodItWorld", 0, 4, true, 2, false);
//    t.checkConstructorException(
//            new IllegalArgumentException("Grid size should be at least 1!"),
//            "FloodItWorld", -50, 4, false, 33, false);
//    t.checkConstructorException(
//            new IllegalArgumentException("Number of colors should be at least 1!"),
//            "FloodItWorld", 1, 0, true, 12, true);
//    t.checkConstructorException(
//            new IllegalArgumentException("Number of colors should be at least 1!"),
//            "FloodItWorld", 90, -3, false, 555, false);
//    t.checkConstructorException(
//            new IllegalArgumentException("If colors are not random, " +
//                    "number of colors should not be more than 8!"),
//            "FloodItWorld", 4, 9, true, 12, false);
//    t.checkConstructorException(
//            new IllegalArgumentException("If colors are not random, " +
//                    "number of colors should not be more than 8!"),
//            "FloodItWorld", 5, 100, false, 555, false);
//  }
//
//  // test for colorsFromRandomPool() method in FloodItWorld class
//  void testColorsFromRandomPool(Tester t) {
//    int numColors = 4;
//    Random rand1 = new Random(Settings.RANDOM_SEED);
//    ArrayList<Color> randomColors1 = new ArrayList<>(numColors);
//
//    for (int i = 0; i < numColors; i++) {
//      Color randomColor1 = new Color(
//              rand1.nextInt(256),
//              rand1.nextInt(256),
//              rand1.nextInt(256));
//
//      randomColors1.add(randomColor1);
//    }
//
//    t.checkExpect(this.game1Rand.colors, randomColors1);
//
//    numColors = 14;
//    Random rand2 = new Random(44444);
//    ArrayList<Color> randomColors2 = new ArrayList<>(numColors);
//
//    for (int i = 0; i < numColors; i++) {
//      Color randomColor2 = new Color(
//              rand2.nextInt(256),
//              rand2.nextInt(256),
//              rand2.nextInt(256));
//
//      randomColors2.add(randomColor2);
//    }
//
//    t.checkExpect(this.game2Rand.colors, randomColors2);
//
//    numColors = 1;
//    Random rand3 = new Random(55552223);
//    ArrayList<Color> randomColors3 = new ArrayList<>(numColors);
//
//    for (int i = 0; i < numColors; i++) {
//      Color randomColor3 = new Color(
//              rand3.nextInt(256),
//              rand3.nextInt(256),
//              rand3.nextInt(256));
//
//      randomColors3.add(randomColor3);
//    }
//
//    t.checkExpect(this.game3Rand.colors, randomColors3);
//  }
//
//  // test for colorsFromStandardPool() method in FloodItWorld class
//  void testColorsFromStandardPool(Tester t) {
//    int numColors = 4;
//    ArrayList<Color> standardColors1 = new ArrayList<>(numColors);
//    for (int i = 0; i < numColors; i++) {
//      standardColors1.add(Settings.COLOR_POOL.get(i));
//    }
//    t.checkExpect(this.game1.colorsFromStandardPool(numColors), standardColors1);
//
//    numColors = 8;
//    ArrayList<Color> standardColors2 = new ArrayList<>(numColors);
//    for (int i = 0; i < numColors; i++) {
//      standardColors2.add(Settings.COLOR_POOL.get(i));
//    }
//    t.checkExpect(this.game2.colorsFromStandardPool(numColors), standardColors2);
//
//    numColors = 1;
//    ArrayList<Color> standardColors3 = new ArrayList<>(numColors);
//    for (int i = 0; i < numColors; i++) {
//      standardColors3.add(Settings.COLOR_POOL.get(i));
//    }
//    t.checkExpect(this.game3.colorsFromStandardPool(numColors), standardColors3);
//  }
//
//  // test onTick() method in FloodItWorld class
//  void testOnTick(Tester t) {
//
//    t.checkExpect(this.game1.titleBar, this.titleBarGame);
//
//    this.game1.onTick();
//    t.checkExpect(this.game1.titleBar, this.titleBar1With1Step);
//
//    this.game2.onTick();
//    this.game2.onTick();
//    this.game2.onTick();
//    this.game2.onTick();
//    t.checkExpect(this.game2.titleBar, this.titleBar2With4Step);
//
//    this.game3.onTick();
//    this.game3.onTick();
//    t.checkExpect(this.game3.titleBar, this.titleBar3With2Step);
//  }
//
//  // test makeScene() method in FloodItWorld class
//  void testMakeScene(Tester t) {
//
//    int centerX1 = game1.width / 2;
//    int centerY1 = game1.height / 2;
//
//    WorldImage gameBackground1 = new RectangleImage(
//            game1.width,
//            game1.height,
//            OutlineMode.SOLID,
//            Color.BLACK);
//
//    WorldImage gameImage1 = new AboveImage(
//            game1.titleBar.image(),
//            game1.infoBar.image(),
//            game1.board.image(),
//            game1.statusBar.image());
//
//    WorldScene gameScene1 = new WorldScene(game1.width, game1.height);
//    gameScene1.placeImageXY(gameBackground1, centerX1, centerY1);
//    gameScene1.placeImageXY(gameImage1, centerX1, centerY1);
//
//    t.checkExpect(game1.makeScene(), gameScene1);
//
//
//    int centerX2 = game2.width / 2;
//    int centerY2 = game2.height / 2;
//
//    WorldImage gameBackground2 = new RectangleImage(
//            game2.width,
//            game2.height,
//            OutlineMode.SOLID,
//            Color.BLACK);
//
//    WorldImage gameImage2 = new AboveImage(
//            game2.titleBar.image(),
//            game2.infoBar.image(),
//            game2.board.image(),
//            game2.statusBar.image());
//
//    WorldScene gameScene2 = new WorldScene(game2.width, game2.height);
//    gameScene2.placeImageXY(gameBackground2, centerX2, centerY2);
//    gameScene2.placeImageXY(gameImage2, centerX2, centerY2);
//
//    t.checkExpect(game2.makeScene(), gameScene2);
//
//
//    int centerX3 = game3.width / 2;
//    int centerY3 = game3.height / 2;
//
//    WorldImage gameBackground3 = new RectangleImage(
//            game3.width,
//            game3.height,
//            OutlineMode.SOLID,
//            Color.BLACK);
//
//    WorldImage gameImage3 = new AboveImage(
//            game3.titleBar.image(),
//            game3.infoBar.image(),
//            game3.board.image(),
//            game3.statusBar.image());
//
//    WorldScene gameScene3 = new WorldScene(game3.width, game3.height);
//    gameScene3.placeImageXY(gameBackground3, centerX3, centerY3);
//    gameScene3.placeImageXY(gameImage3, centerX3, centerY3);
//
//    t.checkExpect(game3.makeScene(), gameScene3);
//  }
//}