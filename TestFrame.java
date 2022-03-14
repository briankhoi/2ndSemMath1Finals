
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestFrame extends JFrame {
    private JPanel panel1;
    private JTextField textField;
    private JLabel label;

    TestFrame() {
        this.setDefaultCloseOperation(TestFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TestFrame frame = new TestFrame();
        ArrayList<LinearEq> obj = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            obj.add(new LinearEq());
            obj.get(i).getLabel().setText(obj.get(i).generateProblem1());
            obj.get(i).getLabel().setPreferredSize(new Dimension(260,40));
            obj.get(i).getTextField().setText("test");
            obj.get(i).getTextField().setPreferredSize(new Dimension(250,60));
            frame.add(obj.get(i).getLabel());
            frame.add(obj.get(i).getTextField());
            frame.pack();
            System.out.println(i);

        }
        /*Action action = new AbstractAction() {

        frame.textField.addActionListener(action);*/
    }

}
