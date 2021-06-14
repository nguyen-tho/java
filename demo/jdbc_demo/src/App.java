import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class App extends JFrame {
    private JLabel lab1, lab2, lab3;
    private JTextField tf1, tf2, tf3;
    private JButton b1, b2, b3;
    private JScrollPane s1;
    private JTable ta1;
    private JPanel p1, p2, p3, p4;

    public App() {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        JFrame frame = new JFrame("QLHS");


        lab1 = new JLabel("Mã HS");
        tf1 = new JTextField();
        tf1.setColumns(10);

        lab2 = new JLabel("Tên HS");
        tf2 = new JTextField();
        tf2.setColumns(20);

        lab3 = new JLabel("Ngày Sinh");
        tf3 = new JTextField();
        tf3.setColumns(10);

        b1 = new JButton("Thêm");
        b1.addActionListener(new AddListener());

        b2 = new JButton("Xoá");
        b2.addActionListener(new DeleteListener());

        b3 = new JButton("Sửa");
        b3.addActionListener(new UpdateListener());

        p1 = new JPanel();
        p1.setSize(100,40);
        p1.add(lab1);
        p1.add(tf1);

        p4 = new JPanel();
        p4.setSize(100,40);
        p4.add(lab3);
        p4.add(tf3);

        p2 = new JPanel();
        p2.setSize(100,40);
        p2.add(lab2);
        p2.add(tf2);

        p3 = new JPanel();
        p3.setSize(100,40);
        p3.add(b1,BorderLayout.CENTER);
        p3.add(b2,BorderLayout.CENTER);
        p3.add(b3,BorderLayout.CENTER);

        frame.setLayout(new GridLayout(4,2));
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);

        frame.setSize(600,400);
        
        setVisible(true);
    }

    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }

    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }

    }

    public static void main(String[] agrs){
        new App();
    }
}
