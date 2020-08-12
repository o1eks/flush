// ----------------------------------------------------------------------------------------------//
//      CS 2510 | Assignment 9 (Flood It World)                                                  //
//                                                                                               //
//      Settings.java                                                                            //
//      Made by Oleksandr Litus & Iryna Soloviava                                                //
// ----------------------------------------------------------------------------------------------//


/* ======================================== IMPORT ============================================= */
import java.util.ArrayList;
import java.awt.Color;


/* ======================================= SETTINGS =========================================== */
// to represent setting of the game
class Settings {


  /* ========== GAME STARTING SETTINGS ======================================================== */
  static final int GRID_SIZE = 8;                            // recommended: above 10, below 40
  static final int NUMBER_OF_COLORS = 4;                     // if not random, max colors: 8
  static final boolean RANDOM_COLORS = true;                 // standard: false
  /* ========================================================================================== */



  /* ========== ADDITIONAL SETTINGS =========================================================== */
  static final boolean USE_SEED = false;                        // in case true
  static final int RANDOM_SEED = 696969;                        // seed will be used

  static final boolean ADAPT_WINDOW_SIZE = true;                // standard: true
  static int WORLD_WIDTH = 500;                                 // in case you don't want adaption
  static int WORLD_HEIGHT = 500;                                // in case you don't want adaption
  /* ========================================================================================== */



  /* ========== TECHNICAL SETTINGS ============================================================ */
  // Basic Visual Settings
  static final int CELL_SIZE = 20;
  static final int MIN_GAME_WIDTH = 300;
  static final int MARGIN = 50;

  // Title Bar Settings
  static final String GAME_TITLE = "WEIRD FLOOD, BUT OK";
  static final int TITLE_SIZE = 24;
  static final Color TITLE_COLOR = Color.MAGENTA;
  static final int TITLE_BAR_HEIGHT = 80;

  // Info Bar Settings
  static final int INFO_SIZE = 18;
  static final Color INFO_COLOR = Color.DARK_GRAY;
  static final int INFO_BAR_HEIGHT = 20;

  // Status Bar Settings
  static final int STATUS_SIZE = 14;
  static final Color STATUS_COLOR = Color.DARK_GRAY;
  static final int STATUS_BAR_HEIGHT = 40;

  // Colors in the game
  static final Color BLANK_COLOR = new Color(0,0, 0, 0);
  static ArrayList<Color> COLOR_POOL = new ArrayList<>(Settings.NUMBER_OF_COLORS);
  static final Color GAME_BACKGROUND_COLOR = Color.BLACK;

  static {
    COLOR_POOL.add(Color.GREEN);
    COLOR_POOL.add(Color.YELLOW);
    COLOR_POOL.add(Color.CYAN);
    COLOR_POOL.add(Color.MAGENTA);
    COLOR_POOL.add(Color.BLUE);
    COLOR_POOL.add(Color.RED);
    COLOR_POOL.add(Color.ORANGE);
    COLOR_POOL.add(Color.PINK);
  }

  // Big Bang Settings
  static final double TICK_RATE = 1.0 / 60.0;

  static {
    if (Settings.ADAPT_WINDOW_SIZE) {

      // adopting worlds width to the game
      if (Settings.GRID_SIZE > 8) {
        Settings.WORLD_WIDTH = (Settings.GRID_SIZE * Settings.CELL_SIZE) + Settings.MARGIN * 2;
      }
      else {
        Settings.WORLD_WIDTH = Settings.MIN_GAME_WIDTH;
      }

      // adopting worlds height to the game
      Settings.WORLD_HEIGHT = Settings.TITLE_BAR_HEIGHT
              + Settings.INFO_BAR_HEIGHT
              + (Settings.GRID_SIZE * Settings.CELL_SIZE)
              + (Settings.MARGIN * 2)
              + Settings.STATUS_BAR_HEIGHT;

    }
  }
}


