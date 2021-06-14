import javax.swing.*;

public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JButton button = new JButton("click");

        button.setBounds(130, 100, 140, 40);

        frame.add(button);

        frame.setSize(400, 500);

        frame.setLayout(null);

        frame.setVisible(true);
    }
}  