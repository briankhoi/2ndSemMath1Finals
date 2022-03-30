 
//source: https://www.javatpoint.com/java-jtable
import javax.swing.*;    

//Table for chapter 6.3
public class expTable extends Chapter6{
  expTable() {
    problemGen();
  }
  
  public void makeTable(Object a[][], Object b[]){
    JTable f = new JTable(a, b);
    this.add(f);
    
  }
  public String generateLinExpTable(){
    int linExp = (int)(Math.random() * 2 + 1);
    int incDec = (int)(Math.random() * 2 + 1);
    Object incExpValues[][] = { {-2, getIncExpValue(-2)}, {-1, getIncExpValue(-1)}, {0, getIncExpValue(0)}, {1, getIncExpValue(1)}, {2, getIncExpValue(2)} };
    Object decExpValues[][] = { {-2, getDecExpValue(-2)}, {-1, getDecExpValue(-1)}, {0, getDecExpValue(0)}, {1, getDecExpValue(1)}, {2, getDecExpValue(2)} };
    Object expValues[][];
    String variables[] = {"x","y"}; 
    if(incDec == 1){
      expValues = incExpValues;
      } else {
      expValues = decExpValues;
      }
    Object linValues[][] = { {-2, getLinValue(-2)}, {-1, getLinValue(-2)}, {0, getLinValue(0)}, {1, getLinValue(1)}, {2, getLinValue(2)} };
    makeTable(expValues, variables);
    setAnswer(linExp);
    return "Determine if the function represented by this table is linear or exponential. Enter 1 for exponential and 2 for linear.";
    }

  public String makeGeoTable(){
    Object geoValues[][] = { {-2, getGeoValue(-2)}, {-1, getGeoValue(-1)}, {0, getGeoValue(0)}, {1, getGeoValue(1)} };
    String variables[] = {"x","y"}; 
    makeTable(geoValues, variables);
    setAnswer(getGeoValue(1)/getGeoValue(0));
    return "Determine the value of r in the function shown by this table. It follows the format ar^n.";
  }
  
  public void problemGen() {
    int problem = (int) (Math.random() * 7 + 1);
    if (problem == 1) {
      this.setLabel(generateLinExpTable());
    } else if (problem == 2) {
      this.setLabel(makeGeoTable());
      } else if (problem == 3) {
      this.setLabel(generateRangeDomainExp());
      } else if (problem == 4) {
      this.setLabel(tableValues());
      } else if (problem == 5) {
      this.setLabel(generatePercentRateChange());
      } else if (problem == 6) {
      this.setLabel(generateGrowthDecayNeitherExp());
      } else {
      this.setLabel(solveExpEquation());
      }
  }
}