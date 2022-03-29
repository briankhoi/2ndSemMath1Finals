//General Chapter 6
public class Chapter6 extends Question {
  private int a;
  private int r;
  private double exDecimal;
  private int constant;
  Chapter6() {
    super();
    while (a == 0 || r == 0 || exDecimal == 0 || constant == 0 || (Math.abs(a) == Math.abs(r)) || (Math.abs(a) == Math.abs(constant) || (Math.abs(r) == Math.abs(constant)))) {
      a = (int) (Math.random() * 10 + 1);
      r = (int) (Math.random() * 5 + 1);
      exDecimal = Double.valueOf(getDFormatter().format(Math.random() * 2 - 1));
      constant = (int) (Math.random() * 10 - 5);
    }
  }

 
//Chapter 6.1

  //Range and domain
  public String generateRangeDomainExp() {
    int domRangDecider = (int)(Math.random() * 2 + 1);
    int decIncDecider = (int)(Math.random() * 2 + 1);
    if (decIncDecider == 1) {
      if (domRangDecider == 1){
        setAnswer(1);
        return "What is the domain of " + generateIncExpEq() + "? Enter 1 for -Infinity to Infinity, 2 for A to Infinity, or 3 for A to zero, where A is a constant.";
      } else if (domRangDecider == 2){
        setAnswer(2);
        return "What is the range of " + generateIncExpEq() + "? Enter 1 for -Infinity to Infinity, 2 for A to Infinity, or 3 for A to zero, where A is a constant.";
      }
    } else {
      if (domRangDecider == 2){
        setAnswer(1);
        return "What is the domain of " + generateDecExpEq() + "? Enter 1 for -Infinity to Infinity, 2 for A to Infinity, or 3 for A to zero, where A is a constant.";
      } else {
        setAnswer(3);
        return "What is the domain of " + generateDecExpEq() + "? Enter 1 for -Infinity to Infinity, 2 for A to Infinity, or 3 for A to zero, where A is a constant.";
      }
    }
    return "";
  }
  
  //Table of values - just tell user to add ex. f(2) + f(1)?
  public String tableValues() {
    int xN = (int)(Math.random() * 11 - 5);
    int xM = (int)(Math.random() * 11 - 5);
    int incDec = (int)(Math.random() * 2 + 1);
    if(incDec == 1){
      setAnswer(getHumanIncExpValue(xM) + getHumanIncExpValue(xN));
      return "Add the values f(" + xM + ") and f(" + xN + ") of " + generateHumanIncExpEq() + ".";
      } else {
      setAnswer(getDecExpValue(xM) + getDecExpValue(xN));
      return "Add the values f(" + xM + ") and f(" + xN + ") of " + generateDecExpEq() + ".";
      }
    
    }


//Chapter 6.2
  public String generateGrowthDecayNeitherExp() { 
    int equationDeterminer = (int) (Math.random() * 3 + 1);
    if (equationDeterminer == 1) { //exponential growth
      setAnswer(1);
      return "Does the function " + generateDecExpEq() +" represent exponential decay, exponential growth, or neither? Enter 1 for decay, 2 for growth, and 3 for neither.";
    } else if (equationDeterminer == 2) { //exp decay
      setAnswer(2);
      return "Does the function " + generateIncExpEq() +" represent exponential decay, exponential growth, or neither? Enter 1 for decay, 2 for growth, and 3 for neither.";
    } else { //neither (linear)
      setAnswer(3);
      return "Does the function " + "y = " + this.a + "x + " + this.r + " represent exponential decay, exponential growth, or neither? Enter 1 for decay, 2 for growth, and 3 for neither.";
    }  
  }

//% Rate of change
  public String generatePercentRateChange() {
    setAnswer(Math.abs(1 - (this.r + this.exDecimal)) * 100);
    return "What is the percent(%) rate of change of this exponential equation: " + generateDecExpEq();
  }

//Chapter 6.3 (tables)
  //generates a human friendly r value exponential equation
  public String generateIncExpEq() {
    return "f(x) = " + this.a + "^(" + this.r + "x) " + this.constant;
  }

  public String generateHumanIncExpEq() {
    return "f(x) = " + (this.a - 5) + "^(" + (this.r - 2) + "x) " + this.constant;
  }

  public double getHumanIncExpValue(int n) {
    return (double)((this.a - 5) * (double)Math.pow(this.r - 2, n));
  }
  //generates a decimal r value exponential equation
  public String generateDecExpEq() {
    return "f(x) = " + this.a + "^(" + (1 + this.exDecimal) + "x) " + this.constant;
  }

  //generates the value of the exponential function y = a^rx at x = n
  public double getIncExpValue(int n){
    return (double)(this.a * (double)Math.pow(this.r, n));
  }
  //generate value of decreasing exp function
  public double getDecExpValue(int n){
    return (double)(this.a * (double)Math.pow(1 - exDecimal, n));
  }
  //generates the value of the linear function y = ax + r
  public int getLinValue(int n){
    return (this.a * n) + this.r;
  }

  //Actual table creation found in expTable.java

//Chapter 6.4 Solving Exponential Equations
  public String solveExpEquation(){
    int formatDeterminer = (int) (Math.random() * 3 + 1);
    int b = (int) (Math.random() * 10 - 9);
    int m = (int)(Math.random() * 10 + 1);
    int n = (int)(Math.random() * 5 + 1);
    int c = (int)(Math.random() * 3 + 1);
    String prompt = "Solve for x. ";
      if(formatDeterminer == 1){
        setAnswer((b / m-1));
        return prompt + this.a + "^x" + " = " + this.a + "^(" +  m + "x + " + b + ")";
      }
      else if(formatDeterminer == 2){
        setAnswer((-n-b)/m);
        return prompt + this.a + "^" + -n + " = " + this.a + "^(" +  m + "x + " + b + ")";
      }
      else if(formatDeterminer == 3){
        setAnswer((double)((-b-c)/m)); 
        return prompt + "1/"+ Math.pow(this.a, c) + " = " + this.a + "^(" +  m + "x + " + b + ")";
      }
    return "";
    }
  //Chapter 6.5 Geometri Sequences
  public int getGeoValue(int n){
    return a *(int) (Math.pow(r,n));
  }
}