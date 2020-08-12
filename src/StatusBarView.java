import javalib.worldimages.*;

class StatusBarView extends AView {

  // ...
  int gameBoardSize;
  int numColors;


  // ...
  StatusBarView(int width, int gameBoardSize, int numColors) {
    super(width, Settings.STATUS_BAR_HEIGHT, 0, 0, 0, 0,
            Settings.BLANK_COLOR, Settings.STATUS_COLOR, Settings.STATUS_SIZE);

    this.gameBoardSize = gameBoardSize;
    this.numColors = numColors;
  }


  // creates an image of the status bar
  public WorldImage makeViewImage() {

    // Strings to represent the grid size and number of colors
    String gridSizeStr = Integer.toString(this.gameBoardSize);
    String numColorsStr = Integer.toString(this.numColors);

    // image to represent grid size
    WorldImage gridSizeImage = new TextImage(
            "Size: " + gridSizeStr + "x" + gridSizeStr,
            this.textSize,
            this.textColor);

    // image to represent number of colors in the game
    WorldImage numColorsImage = new TextImage(
            "#Colors: " + numColorsStr,
            this.textSize,
            this.textColor);

    // image that combines status information
    WorldImage statusInfoImage = new OverlayOffsetAlign(
            AlignModeX.RIGHT, AlignModeY.MIDDLE,
            gridSizeImage,
            numColorsImage.getWidth() + Settings.MARGIN, 0,
            numColorsImage);

    // returns an image of the bar with status info in the middle
    return new OverlayImage(statusInfoImage, this.makeViewCanvasImage());
  }
}
