import java.awt.*;
 2 import java.awt.event.*;
 3 import javax.swing.*;
 4 import java.io.*;
 5 import java.util.Scanner;
 6
 7 /**
 8 The TextEditor class is a simple text editor.
 9 */
10
11 public class TextEditor extends JFrame
12 {
 13 // The following are fields for the menu system.
14 // First, the menu bar
15 private JMenuBar menuBar;

Dũng đã gửi Hôm nay lúc 15:56
// The menus
18 private JMenu fileMenu;
19 private JMenu fontMenu;
20
21 // The menu items
22 private JMenuItem newItem;
 23 private JMenuItem openItem;
 24 private JMenuItem saveItem;
 25 private JMenuItem saveAsItem;
 26 private JMenuItem exitItem;
27
 28 // The radio button menu items
 29 private JRadioButtonMenuItem monoItem;
 30 private JRadioButtonMenuItem serifItem;
 31 private JRadioButtonMenuItem sansSerifItem;
 32
 33 // The checkbox menu items
 34 private JCheckBoxMenuItem italicItem;
 35 private JCheckBoxMenuItem boldItem;
 36
 37 private String filename; // To hold the file name
 38 private JTextArea editorText;// To display the text
 39 private final int NUM_LINES = 20; // Lines to display
40 private final int NUM_CHARS = 40; // Chars per line
41
 42 /**
 43 Constructor
 44 */
 45
 46 public TextEditor()
 47 {
 48 // Set the title.
 49 setTitle("Text Editor");
 50
 51 // Specify what happens when the close
 52 // button is clicked.
 53 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 54
 55 // Create the text area.
 56 editorText = new JTextArea(NUM_LINES, NUM_CHARS);
 57
 58 // Turn line wrapping on.
 59 editorText.setLineWrap(true);
60 editorText.setWrapStyleWord(true);
 61
 62 // Create a scroll pane and add the text area to it.
 63 JScrollPane scrollPane = new JScrollPane(editorText);

Dũng đã gửi Hôm nay lúc 15:56
// Add the scroll pane to the content pane.
66 add(scrollPane);
67
 68 // Build the menu bar.
 69 buildMenuBar();
 70
 71 // Pack and display the window.
 72 pack();
 73 setVisible(true);
 74 }
 75
 76 /**
 77 The buildMenuBar method creates a menu bar and
 78 calls the createFileMenu method to create the
 79 file menu.
 80 */
 81
 82 private void buildMenuBar()
 83 {
 84 // Build the file and font menus.
 85 buildFileMenu();
 86 buildFontMenu();
 87
 88 // Create the menu bar.
 89 menuBar = new JMenuBar();
 90
 91 // Add the file and font menus to the menu bar.
 92 menuBar.add(fileMenu);
 93 menuBar.add(fontMenu);
 94
 95 // Set the menu bar for this frame.
 96 setJMenuBar(menuBar);
 97 }
 98
 99 /**
100 The buildFileMenu method creates the file menu
101 and populates it with its menu items.
102 */
103
104 private void buildFileMenu()
105 {
106 // Create the New menu item.
107 newItem = new JMenuItem("New");
108 newItem.setMnemonic(KeyEvent.VK_N);
109 newItem.addActionListener(new NewListener());
110
111 // Create the Open menu item.
112 openItem = new JMenuItem("Open");