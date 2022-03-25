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
  int perpXAnswer = 
  //Chapter 10.1 asks to identify parallel lines in a 3d structure; skip?
  
  //Chapter 10.2 requires predrawn images.

  //Chapter 10.3 basically same as 10.2

  //Chapter 10.5 Parallel and Perpendicular lines

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
    setAnswer();
    return "Find the point at which the two perpendicular lines " + generateLinFunction() + generatePerpendicularLinFunction + " intersect. Add the x and y values of the coordinate together and input this as the answer.";
  }
}