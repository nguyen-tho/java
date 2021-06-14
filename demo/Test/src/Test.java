import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Set;

import javax.swing.*;

public class Test extends JFrame {
    private JLabel label1, label2;//cần 2 label
    private JRadioButton r1, r2, r3;//3 radio button
    private JButton b, b2;//2 button

    private String result;

    private JTextField tf1, tf2;

    private JPanel panel1, panel2, panel3, panel4;//4 panel tượng trưng cho 4 khu vực


    

    public Test() {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        JFrame cont = new JFrame("test");//tạo mới 1 frame để tạo giao diện
        //setLayout(new BorderLayout());
        

        label1 = new JLabel("Nhập");// label1 để tạo dòng đầu tiên "nhập"
        tf1 = new JTextField();//tf1 là text field dùng để nhập
        tf1.setColumns(30);  // độ dài text field là 30 
        
        label2 = new JLabel("Xuất");// label2 để tạo dòng "xuất"
        tf2 = new JTextField();
        tf2.setEditable(false);//vì chỉ xuất kết quả nên không cho phép thay đổi nội dung
        tf2.setColumns(30);

        b = new JButton("Thực hiện");// button dùng để chạy chương trình
        b.addActionListener( new ConfirmationListener());// action listener để xác nhận có hành động nhấn button

        b2 = new JButton("Xoá");
        b2.addActionListener(new ClearListener());

        //3 radio button để chọn thao tác

        r1 = new JRadioButton("Đảo chiều");
        r2 = new JRadioButton("Đếm từ");
        r3 = new JRadioButton("Từ xuất hiện nhiều nhất");
        
        
        ButtonGroup group= new ButtonGroup(); // dùng button group để tạo một nhóm button
        group.add(r1);// nhằm chọn 1 trong 3 thao tác
        group.add(r2);
        group.add(r3);

        //panel1 dùng để add dòng nhập của giao diện
        panel1 = new JPanel();
        panel1.setSize(200,40);
        panel1.add(label1);
        panel1.add(tf1);

        //panel2 dùng để add dòng radio button của 
        panel2 = new JPanel();
        panel2.setSize(200,40);
        panel2.add(r1);
        panel2.add(r2);
        panel2.add(r3);

        //panel3 dùng để add nút "thực hiện"
        panel3 = new JPanel();
        panel3.setSize(200,40);
        panel3.add(b,BorderLayout.CENTER);
        panel3.add(b2,BorderLayout.CENTER);

        //panel4 dùng để add dòng "xuất" 
        panel4 = new JPanel();
        panel4.setSize(200,40);
        panel4.add(label2);
        panel4.add(tf2);

        //thêm panel vào frame
        cont.setLayout(new GridLayout(4,1));// set layout khiến cho frame chia thành 4 dòng 1 cột
        cont.add(panel1);//add lần lượt các panel
        cont.add(panel2);
        cont.add(panel3);
        cont.add(panel4);

        cont.setSize(400, 300);// set size của giao diện

        
        //pack();
        cont.setVisible(true);// hiện giao diện
    }

    //implement actionPerformed để xử lí sự kiện

    private class ConfirmationListener implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent e) {
        if(r1.isSelected())
        {
            doReverse();
        }
        if(r2.isSelected())
        {
            doCountWords();
        }
        if(r3.isSelected())
        {
            mostRepeatedWords();
        }
    }
//3 thủ tục xử lý

// thủ tục xử lí nếu "đảo chuỗi" được chọn để thực thi
    private void doReverse()
    {
        if(tf1.getText().isEmpty())
        {
            tf2.setText("Chuỗi rỗng");
        }
        else 
        {
            String text = tf1.getText();
            StringBuilder sb = new StringBuilder(text);
            sb.reverse();
            tf2.setText(sb.toString());
        }

    }
// thủ tục xử lí nếu "đếm từ" được chọn để thực thi
    public void doCountWords(){
        if(tf1.getText().isEmpty())
        {
            tf2.setText("0 từ");
        }
        else
        {
            String[] arr = tf1.getText().split(" ");
            result = String.valueOf(tf1.getText()+" có " +arr.length +" từ"); 
            tf2.setText(result); 
        }
    }
// thủ tục xử lí nếu "từ xuất hiện nhiều nhất" được chọn để thực thi
    public void mostRepeatedWords(){
        String str = tf1.getText();
        if(str.isEmpty())
            result = "Không có !";
        else{
            HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

            String[] words = str.split(" ");

            for(String word : words)
            {
                if(wordCount.containsKey(word))
                {
                    wordCount.put(word, wordCount.get(word)+1);
                }
                else{
                    wordCount.put(word, 1);
                }
            }
            Set<String> wordInString = wordCount.keySet();
            int max = 0;
            String maxWord ="";
            for(String word : wordInString){
                if(wordCount.get(word) > max){
                    max = wordCount.get(word);
                    maxWord = word;
                }
            }
            
            tf2.setText(String.valueOf(maxWord));
        }

    }
    }

    private class ClearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                tf1.setText(null);
                tf2.setText("Xin nhập lại");
            
            
        }

    }
//hàm main để khởi chạy
    public static void main(String[] args) {
        Test test = new Test();
    }
}
