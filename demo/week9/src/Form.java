
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;

public class Form extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField tf1, tf2, tf3;
    JRadioButton r1, r2;
    String days31[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String months[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    String years[] = { "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "2000" };
    JComboBox<String> cb1, cb2, cb3;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    JButton submitButton;

    public Form() {
        JFrame f = new JFrame();

        l1 = new JLabel("Họ tên ");
        l1.setBounds(50, 50, 100, 30);
        tf1 = new JTextField();
        tf1.setBounds(100, 50, 200, 30);
        l2 = new JLabel("Giới tính ");
        l2.setBounds(365, 50, 100, 30);
        r1 = new JRadioButton("Nam");
        r1.setBounds(460, 50, 70, 30);
        r2 = new JRadioButton("Nữ");
        r2.setBounds(530, 50, 50, 30);
        ButtonGroup b1 = new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        // dong 2
        l3 = new JLabel("Ngày sinh");
        l3.setBounds(50, 100, 100, 30);
        cb1 = new JComboBox<String>(days31);
        cb1.setBounds(120, 100, 70, 30);
        cb2 = new JComboBox<String>(months);
        cb2.setBounds(190, 100, 70, 30);
        cb3 = new JComboBox<String>(years);
        cb3.setBounds(260, 100, 100, 30);
        l4 = new JLabel("SĐT");
        l4.setBounds(365, 100, 70, 30);
        tf2 = new JTextField();
        tf2.setBounds(400, 100, 200, 30);
        // dong 3
        l5 = new JLabel("Ngoại ngữ");
        l5.setBounds(50, 150, 100, 30);

        checkBox1 = new JCheckBox("Anh", true);
        checkBox1.setBounds(150, 150, 100, 30);
        checkBox2 = new JCheckBox("Pháp");
        checkBox2.setBounds(250, 150, 100, 30);
        checkBox3 = new JCheckBox("Hoa");
        checkBox3.setBounds(350, 150, 100, 30);
        checkBox4 = new JCheckBox("Nhật");
        checkBox4.setBounds(450, 150, 100, 30);

        //nút submit
        submitButton = new JButton("Submit");
        submitButton.setBounds(250, 200, 100, 30);
        submitButton.addActionListener(this);

        //kết quả
        l6 = new JLabel("Kết quả");
        l6.setBounds(100, 250, 100, 30);
        tf3 = new JTextField();
        tf3.setEditable(false);
        tf3.setBounds(150, 250, 450, 30);

        // add form
        f.add(l1);
        f.add(tf1);

        f.add(l2);
        f.add(r1);
        f.add(r2);

        f.add(l3);
        f.add(cb1);
        f.add(cb2);
        f.add(cb3);

        f.add(l4);
        f.add(tf2);

        f.add(l5);
        f.add(checkBox1);
        f.add(checkBox2);
        f.add(checkBox3);
        f.add(checkBox4);

        f.add(submitButton);

        f.add(l6);
        f.add(tf3);

        f.setSize(700, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String result;

        String s1 = tf1.getText();

        String s2 = "";
        if (r1.isSelected()) {
            s2 = r1.getText();
        } else {
            s2 = r2.getText();
        }

        String s3 = (String) cb1.getSelectedItem() + "/" + (String) cb2.getSelectedItem() + "/"
                + (String) cb3.getSelectedItem();

        String s4 = tf2.getText();

        String s5 = "";
        if (checkBox1.isSelected()) {
            s5 += checkBox1.getText() +  " ";
        }
        if (checkBox2.isSelected()) {
            s5 += checkBox2.getText() +  " ";
        }
        if (checkBox3.isSelected()) {
            s5 += checkBox3.getText() +  " ";
        }
        if (checkBox4.isSelected()) {
            s5 += checkBox4.getText() + " ";
        }

        result = "Hello " + s1 + "\t Gioi tinh: " + s2 + "\t Ngay sinh: " + s3 + "\t So dien thoai: " + s4
                + "\t Ngoai ngu: " + s5 + "\n";
        tf3.setText(String.valueOf(result));
            
        try {
            FileOutputStream fos = new FileOutputStream("C:/Users/MyPC/Desktop/demo/week9/src/mydata.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeBytes(result);

            fos.close();
            dos.close();
            System.out.println("Done!");
        } catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
       Form form = new Form();
    }
}