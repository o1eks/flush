// ----------------------------------------------------------------------------------------------//
//      CS 2510 | Assignment 9 (Flood It World)                                                  //
//                                                                                               //
//      AView.java                                                                               //
//      Made by Oleksandr Litus & Iryna Soloviova                                                //
// ----------------------------------------------------------------------------------------------//

import java.awt.Color;
import javalib.worldimages.*;

// to represent a view (graphical interface unit that has one context)
abstract class AView implements IView {

  // width and height of the view, without margins
  int width;
  int height;

  // margins of the view
  int topMargin;
  int bottomMargin;
  int rightMargin;
  int leftMargin;

  // colors used in the view
  Color backgroundColor;
  Color textColor;
  int textSize;


  // full constructor with all fields given
  AView(int width, int height, int topMargin, int bottomMargin, int rightMargin,  int leftMargin,
        Color backgroundColor, Color textColor, int textSize) {
    this.width = width;
    this.height = height;
    this.topMargin = topMargin;
    this.bottomMargin = bottomMargin;
    this.rightMargin = rightMargin;
    this.leftMargin = leftMargin;
    this.backgroundColor = backgroundColor;
    this.textColor = textColor;
    this.textSize = textSize;
  }


  // updates the view with each clock tick
  public void update() {
    // does nothing
  }

  // creates an image of the view
  public abstract WorldImage makeViewImage();

  // creates an image of the canvas, where view is placed
  public WorldImage makeViewCanvasImage() {
    return new RectangleImage(
            this.width + this.rightMargin + this.leftMargin,
            this.height + this.topMargin + this.rightMargin,
            OutlineMode.SOLID,
            this.backgroundColor);
  }

  // handles mouse click inside the view
  // in the given position, zero point is in the top left corner of the view
  public void onMouseClicked(Posn pos) {
    // does nothing
  }
}
