import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener{
    
    private JButton plus;
    private JButton minus;
    private JButton multi;
    private JButton div;

    private double result;

    private Container container;

    private JTextField aField, bField, kqField;

    private JPanel panel1, panel2;

    public Calculator() {
        

        JLabel label1 = new JLabel("Number a: ");
        aField = new JTextField();

        JLabel label2 = new JLabel("Number b: ");
        bField = new JTextField();

        JLabel label3 = new JLabel("Number kq: ");
        kqField = new JTextField();

        kqField.setEditable(false);

        panel1 = new JPanel();

        panel1.add(label1);
        panel1.add(aField);
        panel1.add(label2);
        panel1.add(bField);
        panel1.add(label3);
        panel1.add(kqField);

        plus = new JButton("+");
        minus = new JButton("-");
        multi = new JButton("*");
        div = new JButton("/");

        panel2 = new JPanel();

        panel2.add(plus);
        panel2.add(minus);
        panel2.add(div);
        panel2.add(multi);

        container.add(panel1);
        container.add(panel2, "South");

        plus.addActionListener(this);
        minus.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);

        pack();
        setVisible(true);
    }

    public void doPlus(){
        result = Double.parseDouble(aField.getText()) + Double.parseDouble(bField.getText());
        kqField.setText(String.valueOf(result));
    }

    public void doMinus(){
        result = Double.parseDouble(aField.getText()) - Double.parseDouble(bField.getText());
        kqField.setText(String.valueOf(result));
    }

    public void doMultiply(){
        result = Double.parseDouble(aField.getText()) * Double.parseDouble(bField.getText());
        kqField.setText(String.valueOf(result));
    }

    public void doDiv(){
        if(Double.parseDouble(bField.getText()) == 0)
            kqField.setText("Cannot divide for 0");
        else
        {
            result = Double.parseDouble(aField.getText()) / Double.parseDouble(bField.getText());
            kqField.setText(String.valueOf(result));
        }

    }

    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand()=="+")
		doPlus();
		if (e.getActionCommand()=="-")
		doMinus();
		if (e.getActionCommand()=="*")
		doMultiply();
		if (e.getActionCommand()=="/")
		doDiv();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setLocationRelativeTo(null);
        
    }

}
