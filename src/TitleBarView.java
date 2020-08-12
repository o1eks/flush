// ----------------------------------------------------------------------------------------------//
//      CS 2510 | Assignment 9 (Flood It World)                                                  //
//                                                                                               //
//      TitleBarView.java                                                                        //
//      Made by Oleksandr Litus & Iryna Soloviova                                                //
// ----------------------------------------------------------------------------------------------//

import javalib.worldimages.*;
import java.awt.*;

// to represent a title bar view
class TitleBarView extends AView {

  // content of the view
  String title;

  // animation variables for the title
  double dx;
  double dy;
  double ddx;
  double ddy;


  // full constructor with all fields given
  TitleBarView(int width, int height, int topMargin, int bottomMargin, int rightMargin,
               int leftMargin,
               Color backColor, Color textColor, int textSize, String title,
               double dx, double dy, double ddx, double ddy) {
    super(width, height, topMargin, bottomMargin, rightMargin, leftMargin, backColor, textColor,
            textSize);
    this.title = title;
    this.dx = dx;
    this.dy = dy;
    this.ddx = ddx;
    this.ddy = ddy;
  }

  // ...
  TitleBarView(int width, String title, double dx, double dy, double ddx, double ddy) {
    this(width, Settings.TITLE_BAR_HEIGHT, 0, 0, 0, 0,
            Settings.BLANK_COLOR, Settings.TITLE_COLOR, Settings.TITLE_SIZE, title, dx, dy,
            ddx, ddy);
  }

  // ...
  // creates a title bar with the given width based on initial settings
  TitleBarView(int width) {
    this(width, Settings.GAME_TITLE, 0, 0, 0.5, -0.5);
  }


  // to create image of the title bar view with the title moving in the middle of the canvas
  public WorldImage makeViewImage() {
    // to create an image of the title
    WorldImage titleImage = new OverlayOffsetImage(
            new TextImage(this.title, Settings.TITLE_SIZE, Settings.TITLE_COLOR),
            this.dx, this.dy,
            new TextImage(this.title, Settings.TITLE_SIZE, Settings.TITLE_COLOR.darker()));

    // return the imag of the title bar with title placed on the canvas
    return new OverlayImage(titleImage, this.makeViewCanvasImage());
  }

  // updates the speed and direction of the title movement
  public void update() {

    if (this.dx == 10) {
      this.ddx = -0.5;
      this.ddy = 0.5;
    }

    else if (this.dx == -10) {
      this.ddx = 0.5;
      this.ddy = -0.5;
    }

    this.dx += this.ddx;
    this.dy += this.ddy;
  }
}
