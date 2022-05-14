public class Chapter11 extends Question {
  int shapeDeterminer = 0;
  int verticalShift = 0;
  int horizontalShift = 0;
  int pointAX = 0;
  int pointAY = 0;
  int pointBX = 0;
  int pointBY = 0;
  int pointCX = 0;
  int pointCY = 0;
  int elevenXOrY = 0;
  int reflectXOrY = 0;
  int sqTriDeterminer = 0;
  int pointDX;
  int pointDY;
  int rotation;

  Chapter11() {
    super();
    shapeDeterminer = (int) (Math.random() * 3 + 1);
    verticalShift = (int) (Math.random() * 11 - 5);
    horizontalShift = (int) (Math.random() * 11 - 5);
    pointAX = (int) (Math.random() * 9 - 4);
    pointAY = (int) (Math.random() * 9 - 4);
    pointBX = pointAX + 5;
    pointBY = (int) (Math.random() * 9 - 4);
    pointCX = (int) (Math.random() * 9 - 4);
    pointCY = (int) (Math.random() * 9 - 4);
    pointDX = (int) (Math.random() * 9 - 4);
    pointDY = (int) (Math.random() * 9 - 4);
    elevenXOrY = (int) (Math.random() * 2 + 1);
    reflectXOrY = (int) (Math.random() * 2 + 1);
    sqTriDeterminer = (int) (Math.random() * 2 + 1);
    rotation = (int) (Math.random() * 3 + 1);
  }

  // Chapter 11.1: Translating line segments and shapes
  public String translationProblem() { // what is the difference between the shapedterminer1
    if (shapeDeterminer == 1) {
      if (elevenXOrY == 1) {
        setAnswer(pointAX + pointBX + 2 * horizontalShift);
        return "Shape A is a line segment with points (" + pointAX + "," + pointAY + ") and (" + pointBX + "," + pointBY
            + ") that is translated " + verticalShift + " units vertically and " + horizontalShift
            + " units horizontally. Add the resulting values of x for each of the points and input this as your answer.";
      } else {
        setAnswer(pointAY + pointBY + 2 * verticalShift);
        return "Shape A is a line segment with points (" + pointAX + "," + pointAY + ") and (" + pointBX + "," + pointBY
            + ") that is translated " + verticalShift + " units vertically and " + horizontalShift
            + " units horizontally. Add the resulting values of x for each of the points and input this as your answer.";
      }
    } else if (shapeDeterminer == 2) {
      if (elevenXOrY == 1) {
        setAnswer(pointAX + pointBX + pointCX + 3 * horizontalShift);
        return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is translated " + verticalShift
            + " units vertically and " + horizontalShift
            + " units horizontally. Add the resulting values of x for each of the points and input this as your answer.";
      } else {
        setAnswer(pointAY + pointBY + pointCX + 3 * verticalShift);
        return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is translated " + verticalShift
            + " units vertically and " + horizontalShift
            + " units horizontally. Add the resulting values of x for each of the points and input this as your answer.";
      }
    } else if (shapeDeterminer == 3) {
      if (elevenXOrY == 1) {
        setAnswer(pointAX + pointBX + pointCX + pointDX + 4 * horizontalShift);
        return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is translated "
            + verticalShift + " units vertically and " + horizontalShift
            + " units horizontally. Add the resulting values of x for each of the points and input this as your answer.";
      } else {
        setAnswer(pointAY + pointBY + pointCX + pointDX + pointDY + 4 * verticalShift);
        return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is translated "
            + verticalShift + " units vertically and " + horizontalShift
            + " units horizontally. Add the resulting values of x for each of the points and input this as your answer.";
      }
    }
    return "";
  }

  //11.2 reflections
  public String reflectionProblem() {
    if (sqTriDeterminer == 1){
      if (reflectXOrY == 1){
        if(elevenXOrY == 1){
          setAnswer(pointAX + pointBX + pointCX);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is reflected over the x axis. Add the resulting values of x for each of the points and input this as your answer.";
          } else if(elevenXOrY == 2){
          setAnswer(- pointAY - pointBY - pointCY);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is reflected over the x axis. Add the resulting values of y for each of the points and input this as your answer.";
          } 
        } else {
        if(elevenXOrY == 1){
          setAnswer(- pointAX - pointBX - pointCX);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is reflected over the y axis. Add the resulting values of x for each of the points and input this as your answer.";
          } else if(elevenXOrY == 2){
          setAnswer(pointAY + pointBY + pointCY);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is reflected over the y axis. Add the resulting values of y for each of the points and input this as your answer.";
        }
      }
      return "";
    } else if (sqTriDeterminer == 2){
      if (reflectXOrY == 1){
        if(elevenXOrY == 1){
          setAnswer(pointAX + pointBX + pointCX + pointDX);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is reflected over the x axis. Add the resulting values of x for each of the points and input this as your answer.";
          } else if(elevenXOrY == 2){
          setAnswer(- pointAY - pointBY - pointCY - pointDY);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is reflected over the x axis. Add the resulting values of y for each of the points and input this as your answer.";
          } 
        } else {
        if(elevenXOrY == 1){
          setAnswer(- pointAX - pointBX - pointCX - pointDX);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is reflected over the y axis. Add the resulting values of x for each of the points and input this as your answer.";
          } else if(elevenXOrY == 2){
          setAnswer(pointAY + pointBY + pointCY + pointDY);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is reflected over the y axis. Add the resulting values of y for each of the points and input this as your answer.";
        }
      }
    }
    return "";
  }
  //11.3 rotating about the origin
  public String rotationProblem(){
    if(elevenXOrY == 1){
      if(sqTriDeterminer == 1){
        if(rotation == 1){
          setAnswer(- pointAY - pointBY - pointCY);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is rotated 90 degrees about the origin. Add the resulting values of x for each of the points and input this as your answer.";
        } else if (rotation == 2){
          setAnswer(- pointAX - pointBX - pointCX);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is rotated 180 degrees about the origin. Add the resulting values of x for each of the points and input this as your answer.";
        } else if (rotation == 3){
          setAnswer(pointAY + pointBY + pointCY);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is rotated 270 degrees about the origin. Add the resulting values of x for each of the points and input this as your answer.";
        }
      } else if (sqTriDeterminer == 2){
        if(rotation == 1){
          setAnswer(- pointAY - pointBY - pointCY - pointDY);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is rotated 90 degrees about the origin. Add the resulting values of x for each of the points and input this as your answer.";
        } else if (rotation == 2){
          setAnswer(- pointAX - pointBX - pointCX - pointDX);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is rotated 180 degrees about the origin. Add the resulting values of x for each of the points and input this as your answer.";
        } else if (rotation == 3){
          setAnswer(pointAY + pointBY + pointCY + pointDY);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is rotated 270 degrees about the origin. Add the resulting values of x for each of the points and input this as your answer.";
        }
      }
    } else if (elevenXOrY == 2){
      if(sqTriDeterminer == 1){
        if(rotation == 1){
          setAnswer(pointAX + pointBX + pointCX);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is rotated 90 degrees about the origin. Add the resulting values of y for each of the points and input this as your answer.";
        } else if (rotation == 2){
          setAnswer(- pointAY - pointBY - pointCY);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is rotated 180 degrees about the origin. Add the resulting values of y for each of the points and input this as your answer.";
        } else if (rotation == 3){
          setAnswer(- pointAX - pointBX - pointCX);
          return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), and " + "(" + pointCX + "," + pointCY + ") that is rotated 270 degrees about the origin. Add the resulting values of y for each of the points and input this as your answer.";
        }
      } else if (sqTriDeterminer == 2){
        if(rotation == 1){
          setAnswer(pointAX + pointBX + pointCX + pointDY);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is rotated 90 degrees about the origin. Add the resulting values of y for each of the points and input this as your answer.";
        } else if (rotation == 2){
          setAnswer(- pointAY - pointBY - pointCY - pointDY);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is rotated 180 degrees about the origin. Add the resulting values of y for each of the points and input this as your answer.";
        } else if (rotation == 3){
          setAnswer(- pointAX - pointBX - pointCX - pointDX);
          return "Shape A is a quadrilateral with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY
            + "), (" + pointCX + "," + pointCY + "), and " + "(" + pointDX + "," + pointDY + ") that is rotated 270 degrees about the origin. Add the resulting values of y for each of the points and input this as your answer.";
        }
      }
    }
    return "";
  }
}