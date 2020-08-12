import javalib.worldimages.OverlayImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;

// ...
class InfoBarView extends AView {

  // ...
  int currentStep;
  int totalSteps;


  // ...
  InfoBarView(int width, int currentStep, int totalSteps) {
    super(width, Settings.INFO_BAR_HEIGHT, 0, 0, 0, 0,
            Settings.BLANK_COLOR, Settings.INFO_COLOR, Settings.INFO_SIZE);
    this.currentStep = currentStep;
    this.totalSteps = totalSteps;
  }

  // ...
  InfoBarView(int width) {
    this(width, 0, 100);
  }


  // to create an image of the info bar
  public WorldImage makeViewImage() {

    // strings to represent currentStep and totalSteps
    String currentStepStr = Integer.toString(this.currentStep);
    String totalStepsStr = Integer.toString(this.totalSteps);

    // image to represent teh score
    WorldImage scoreImage = new TextImage(
            "Score: " + currentStepStr + "/" + totalStepsStr,
            this.textSize,
            this.textColor);

    // returns the information image places on the canvas of bars size
    return new OverlayImage(scoreImage, this.makeViewCanvasImage());
  }
}
