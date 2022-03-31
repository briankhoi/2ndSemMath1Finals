public class Chapter11 extends Question{
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
  Chapter11() {
    super();
    int shapeDeterminer = (int)(Math.random() * 3 + 1);
    int verticalShift = (int)(Math.random() * 11 - 5);
    int horizontalShift = (int)(Math.random() * 11 - 5);
    int pointAX = (int)(Math.random() * 9 - 4);
    int pointAY = (int)(Math.random() * 9 - 4);
    int pointBX = pointAX + 5;
    int pointBY = (int)(Math.random() * 9 - 4);
    int pointCX = (int)(Math.random() * 9 - 4);
    int pointCY = (int)(Math.random() * 9 - 4);
    int pointDX = (int)(Math.random() * 9 - 4);
    int pointDY = (int)(Math.random() * 9 - 4);    
    int elevenXOrY = (int)(Math.random() * 2 + 1);
  }
  
  //Chapter 11.1: Translating line segments and shapes
  public String translationProblem(){ //what is the difference between the shapedterminer1
    if (shapeDeterminer == 1){
      if (elevenXOrY == 1){
        setAnswer(pointAX + pointBX + 2 * horizontalShift);
        return "Shape A is a line segment with points (" + pointAX + "," + pointAY + ") and (" + pointBX + "," + pointBY + ") that is translated " + verticalShift + " units vertically and " + horizontalShift + " units horizontally. Add the resulting values of x for each of the ends of the line segment and input this as your answer.";
      } else {
        setAnswer(pointAY + pointBY + 2 * verticalShift);
        return "Shape A is a line segment with points (" + pointAX + "," + pointAY + ") and (" + pointBX + "," + pointBY + ") that is translated " + verticalShift + " units vertically and " + horizontalShift + " units horizontally. Add the resulting values of x for each of the ends of the line segment and input this as your answer.";
      }
    }
    else if (shapeDeterminer == 2){
      if (elevenXOrY == 1){
        setAnswer(pointAX + pointBX + pointCX + 3 * horizontalShift);
        return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY + "), and " + "(" + pointAX + "," + pointAY + ") that is translated " + verticalShift + " units vertically and " + horizontalShift + " units horizontally. Add the resulting values of x for each of the ends of the line segment and input this as your answer.";
      } else {
        setAnswer(pointAY + pointBY + pointCX + 3 * verticalShift);
        return "Shape A is a triangle with points (" + pointAX + "," + pointAY + "), (" + pointBX + "," + pointBY + "), and " + "(" + pointAX + "," + pointAY + ") that is translated " + verticalShift + " units vertically and " + horizontalShift + " units horizontally. Add the resulting values of x for each of the ends of the line segment and input this as your answer.";
    }
  }
    return "";
} 
}