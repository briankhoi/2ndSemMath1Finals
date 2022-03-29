public class Chapter11 extends Question{
  int shapeDeterminer = (int)(Math.random() * 3 + 1);
  int verticalShift = (int)(Math.random() * 11 - 5);
  int horizontalShift = (int)(Math.random() * 11 - 5);
  int pointAX = (int)(Math.random() * 9 - 4);
  int pointBX = (int)(Math.random() * 9 - 4);
  int elevenXOrY = (int)(Math.random() * 2 + 1);
  
  //Chapter 11.1: Translating line segments and shapes
  public String translationProblem(){
    if (shapeDeterminer == 1){
      if (elevenXOrY == 1){
        setAnswer(2 /*two x values added together*/);
        return "Shape A is a line segment that is translated " + verticalShift + " units vertically and " + horizontalShift + " units horizontally. Add the resulting values of x for each of the ends of the line segment and input this as your answer.";
      }
    }
    return "";
  }
}