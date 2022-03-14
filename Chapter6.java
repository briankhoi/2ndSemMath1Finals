//General Chapter 6
public class Chapter6 extends Question {
  private int a;
  private int r;
  private double error;
  private int constant;
  Chapter6() {
    super();
    while (a == 0 || r == 0 || error == 0 || constant == 0 || (Math.abs(a) == Math.abs(r)) || (Math.abs(a) == Math.abs(constant) || (Math.abs(r) == Math.abs(constant)))) {
      a = (int) (Math.random() * 10 + 1);
      r = (int) (Math.random() * 5 + 1);
      // error = DFormatter.format(Math.random() * 2 - 1);
      constant = (int) (Math.random() * 10 - 5);
    }
  }

  //accessor (get) methods
  public int getR() {
    return this.r;
  }

  public int getA() {
    return this.a;
  }

  public double getError() {
    return this.error;
  }

  public int getConstant() {
    return this.constant;
  }

//Chapter 6.1

  //Range and domain
  public String generateRangeDomainExp() {
    if (getError() > 0) {
      //how do we store answer?
    } else {
      //?
    }
    return "What is the domain and range of " + generateDecExpEq();
    }
  //Table of values


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
      return "Does the function " + "y = " + getA() + "x + " + getR() + " represent exponential decay, exponential growth, or neither? Enter 1 for decay, 2 for growth, and 3 for neither.";
    }  
  }

//% Rate of change
  public String generatePercentRateChange() {
    setAnswer(Math.abs(1 - (getR() + getError())) * 100);
    return "What is the percent(%) rate of change of this exponential equation: " + generateDecExpEq();
  }

//Chapter 6.3 (tables)
  //generates a human friendly r value exponential equation
  public String generateIncExpEq() {
    return "y = " + getA() + "(" + getR() + ") " + getConstant();
  }

  //generates a decimal r value exponential equation
  public String generateDecExpEq() {
    return "y = " + getA() + "(" + (1 + getError()) + ") " + getConstant();
  }
  //generates the value of the exponential function y = a^rx at x = n
  public double getExpValue(int n){
    return (double)(getA()) * (double)Math.pow(getR(), n);
  }
  //generates the value of the linear function y = ax + r
  public int getLinValue(int n){
    return (getA() * n) + getR();
  }

  //Actual table creation found in expTable.java

//Chapter 6.4 Solving Exponential Equations
  public String solveExpEquation(){
    int formatDeterminer = (int) (Math.random() * 3 + 1);
    int b = (int) (Math.random() * 10 - 9);
    int m = (int)(Math.random() * 10 + 1);
    int n = (int)(Math.random() * 5 + 1);
    int c = (int)(Math.random() * 3 + 1);
      if(formatDeterminer == 1){
        setAnswer((b / m-1));
        return getA() + "^x" + " = " + getA() + "^(" +  m + "x + " + b + ")";
      }
      else if(formatDeterminer == 2){
        setAnswer((-n-b)/m);
        return getA() + "^" + -n + " = " + getA() + "^(" +  m + "x + " + b + ")";
      }
      else if(formatDeterminer == 3){
        setAnswer((double)((-b-c)/m)); 
        return "1/("+ Math.pow(getA(), c) + " = " + getA() + "^(" +  m + "x + " + b + ")";
      }
    return "";
    }

   
  //Chapter 6.5 Geometric Sequences
}