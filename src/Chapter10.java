import javax.swing.*;

public class Chapter10 extends Question {
  Chapter10() {
    super();
  }
  int m = (int)(Math.random() * 10 + 1);
  int b = (int)(Math.random() * 15 + 1);
  int parallelDistance = (int)(Math.random() * 10 + 1);
  int perpSlope = - 1 / m;
  int perpB = (int)(Math.random() * 10 + 1);
  int perpXAnswer = (perpB - b) * (m + perpSlope);
  int perpYAnswer = m * perpXAnswer + b;
  int xImageType = (int)(Math.random() * 2 + 1);
  int angleA = (int)(Math.random() * 80 + 1);
  int xOrY = (int)(Math.random() * 2 + 1);
  
  //Chapter 10.1 asks to identify parallel lines in a 3d structure; skip
  
  //Chapter 10.2 requires predrawn images, find value of x
  public String xImageProblem(){
    if (xImageType == 1){
      //create image type 1 (#5 on chapter review 10.2)
      if (xOrY == 1){
        setAnswer(180 - angleA);
        return "Angle A is " + angleA + " degrees. Find the value of x based on this information.";
      }
      else {
        setAnswer(angleA);
        return "Angle A is " + angleA + " degrees. Find the value of y based on this information.";
      }
    }
    else if (xImageType == 2){
      //create image type 2 (#6 on chapter review 10.2)
      if(xOrY == 1){
        setAnswer(180 - angleA);
        return "Angle A is " + angleA + " degrees. Find the value of y based on this information.";
      } else {
        setAnswer((angleA - b)/m);
        return "Angle A is " + angleA + " degrees. Angle B is represented by the function " + generateLinFunction() + ". Find the value of x based on this information.";
      }
    }
    return "";
  }

  //Chapter 10.3 basically same as 10.2 - skip

  //Chapter 10.5 Parallel and Perpendicular lines - done

  public String generateLinFunction(){
    return "y = " + m + "x + " + b;
  }
  public String generateParallelLinFunction(){
    return "y = " + m + "x + " + (b + parallelDistance);
  }
  public String generatePerpendicularLinFunction(){
    return "y = " + perpSlope + "x + " + (perpB);    
  }
  
  public String parallelProblem(){
    setAnswer(parallelDistance);
    return "Find the distance between the parallel lines" + generateLinFunction() + " and " + generateParallelLinFunction() + ".";
    }

  public String perpendicularProblem(){
    setAnswer(perpXAnswer + perpYAnswer);
    return "Find the point at which the two perpendicular lines " + generateLinFunction() + generatePerpendicularLinFunction() + " intersect. Add the x and y values of the coordinate together and input this as the answer.";
  }
}