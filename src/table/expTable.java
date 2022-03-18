
//source: https://www.javatpoint.com/java-jtable
import javax.swing.*;    

//Table for chapter 6.3
public class expTable extends Chapter6{
  Jframe f;
  String variables[] = {"x","y"}; 
  expTable(Object a, Object b){
    f = new JFrame();   
    JTable expTable = new JTable(a,b); 
    f.setVisible(true);
  }
}