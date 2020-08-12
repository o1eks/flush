// ----------------------------------------------------------------------------------------------//
//      CS 2510 | Assignment 9 (Flood It World)                                                  //
//                                                                                               //
//      IView.java                                                                               //
//      Made by Oleksandr Litus & Iryna Soloviova                                                //
// ----------------------------------------------------------------------------------------------//


import javalib.worldimages.*;

// to represent a view (graphical interface unit that has one context)
interface IView {

  // updates the view with each clock tick
  void update();

  // creates an image of the view
  WorldImage makeViewImage();

  // creates an image of the canvas, where view is placed
  WorldImage makeViewCanvasImage();

  // handles mouse click inside the view
  // in the given position, zero point is in the top left corner of the view
  void onMouseClicked(Posn pos);
}


