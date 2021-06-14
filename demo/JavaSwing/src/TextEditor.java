import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
//class TextEditor là 1 frame nên extends JFrame

//javax.swing.* là phần được phát triển bởi java.awt
public class TextEditor extends JFrame {

    /**
     *
     */

    /**
     *
     */
    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu fontMenu;

    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem exitItem;

    private JRadioButtonMenuItem monoItem;
    private JRadioButtonMenuItem serifItem;
    private JRadioButtonMenuItem sansSerifItem;

    private JCheckBoxMenuItem italicItem;
    private JCheckBoxMenuItem boldItem;

    private String filename; // To hold the file name
    private JTextArea editorText;// To display the text
    private final int NUM_LINES = 20; // Lines to display
    private final int NUM_CHARS = 40;
//Constructor khởi tạo giá trị mặc định
    public TextEditor() {
        setTitle("Text Editor");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// set default

        editorText = new JTextArea(NUM_LINES, NUM_CHARS);// 20 dòng 40 chữ được hiện ra

        editorText.setLineWrap(true);
        editorText.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(editorText);// nếu nhiều hơn thì phải có thanh cuộn

        add(scrollPane);

        buildMenuBar();

        pack();// cho phép thay đổi kích thước

        setVisible(true);
    }
// tạo Menu bar
    private void buildMenuBar() {
        buildFileMenu();
        buildFontMenu();

        menuBar = new JMenuBar();

        menuBar.add(fileMenu);
        menuBar.add(fontMenu);

        setJMenuBar(menuBar);
    }
//tạo file menu
    private void buildFileMenu() {
        newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);//VK_N phím tắt
        newItem.addActionListener(new NewListener());// phải addActionListener để xử lí

        openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.addActionListener(new OpenListener());

        saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        openItem.addActionListener(new SaveListener());

        saveAsItem = new JMenuItem("Save As");
        saveAsItem.setMnemonic(KeyEvent.VK_A);
        saveAsItem.addActionListener(new SaveListener());

        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitListener());

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();// Separator bar
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();// Separator bar
        fileMenu.add(exitItem);
    }
// tạo font Menu
    private void buildFontMenu() {
        monoItem = new JRadioButtonMenuItem("Monospaced");
        monoItem.addActionListener(new FontListener());

        serifItem = new JRadioButtonMenuItem("Serif");
        serifItem.addActionListener(new FontListener());

        sansSerifItem = new JRadioButtonMenuItem("SansSerif", true);// radio button chọn 1 trong n
        sansSerifItem.addActionListener(new FontListener());

        ButtonGroup group = new ButtonGroup();// phải group để chọn
        group.add(monoItem);
        group.add(serifItem);
        group.add(sansSerifItem);

        italicItem = new JCheckBoxMenuItem("Italic");//
        italicItem.addActionListener(new FontListener());

        boldItem = new JCheckBoxMenuItem("Bold");
        boldItem.addActionListener(new FontListener());

        fontMenu = new JMenu("Font");
        fontMenu.setMnemonic(KeyEvent.VK_T);

        fontMenu.add(monoItem);
        fontMenu.add(serifItem);
        fontMenu.add(sansSerifItem);
        fontMenu.addSeparator();// đường cắt ngang
        fontMenu.add(italicItem);
        fontMenu.add(boldItem);

    }
// xử lí sự kiện
//từng sự kiện phải implements ActionListener
//định nghĩa lại method actionPerformed
    private class NewListener implements ActionListener {// New
        public void actionPerformed(ActionEvent e) {
            editorText.setText("");
            filename = null;
        }
    }

    private class OpenListener implements ActionListener {//Open
        public void actionPerformed(ActionEvent e) {
            int chooserStatus;
            JFileChooser chooser = new JFileChooser();
            chooserStatus = chooser.showOpenDialog(null);

            if (chooserStatus == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();

                filename = selectedFile.getPath();// lấy đường dẫn file

                if (!openFile(filename)) {// không mở được thì báo lỗi
                    JOptionPane.showMessageDialog(null, "Error reading " + filename, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        private boolean openFile(String filename) {// chỉ phục vụ cho class OpenListener nên private
            boolean success;
            String inputLine, editorString = "";

            try {
                File file = new File(filename);
                Scanner inputFile = new Scanner(file);

                while (inputFile.hasNext()) {
                    inputLine = inputFile.nextLine();

                    editorString = editorString + inputLine + "\n";

                    

                   
                }

                    editorText.setText(editorString);

                    inputFile.close();

                    success = true;
            } catch (IOException e) {
                success = false;
            }

            return success;
        }
    }

    private class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int chooserStatus;

            if (e.getActionCommand() == "Save As" || filename == null) {
                JFileChooser chooser = new JFileChooser();
                chooserStatus = chooser.showSaveDialog(null);
                if (chooserStatus == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    filename = selectedFile.getPath();
                }

               
            }

            if (!saveFile(filename)) {
                JOptionPane.showMessageDialog(null, "Error saving" + filename, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private boolean saveFile(String filename) {
            boolean success;
            String editorString;
            PrintWriter outputFile;

            try {
                outputFile = new PrintWriter(filename);

                editorString = editorText.getText();
                outputFile.print(editorString);

                outputFile.close();

                success = true;
            } catch (IOException e) {
                success = false;
            }

            return success;
        }
    }

    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class FontListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Font textFont = editorText.getFont();

            String fontName = textFont.getName();
            int fontSize = textFont.getSize();

            int fontStyle = Font.PLAIN;

            if (monoItem.isSelected())
                fontName = "Monospaced";
            else if (serifItem.isSelected())
                fontName = "Serif";
            else if (sansSerifItem.isSelected())
                fontName = "SansSerif";

            if (italicItem.isSelected())
                fontStyle += Font.ITALIC;

            if (boldItem.isSelected())
                fontStyle += Font.BOLD;

            editorText.setFont(new Font(fontName, fontStyle, fontSize));

        }
    }

    public static void main(String[] args) {
         new TextEditor();
    }
}
