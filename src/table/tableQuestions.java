public class tableQuestions extends expTable{
  public String generateLinExpTable(){
    int linExp = (int)(Math.random() * 2 + 1);
    int incDec = (int)(Math.random() * 2 + 1);
    String variables[] = {"x","y"}; 
    if(incDec == 1){
      Object expValues[][] = { {-2, getIncExpValue(-2)}, {-1, getIncExpValue(-1)}, {0, getIncExpValue(0)}, {1, getIncExpValue(1)}, {2, getIncExpValue(2)} };
      } else {
      Object expValues[][] = { {-2, getDecExpValue(-2)}, {-1, getDecExpValue(-1)}, {0, getIncDecValue(0)}, {1, getDecExpValue(1)}, {2, getDecExpValue(2)} };
      }
    Object linValues[][] = { {-2, getLinValue(-2)}, {-1, getLinValue(-2)}, {0, getLinValue(0)}, {1, getLinValue(1)}, {2, getLinValue(2)} };
    expTable(expValues, variables);
    setAnswer(linExp);
    return "Determine if the function represented by this table is linear or exponential. Enter 1 for exponential and 2 for linear.";
  }
}