package musictool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class KeyboardFrame extends JFrame {

  JTextArea displayArea;
  JTextField typingArea;

  ButtonListener actionListener;
  KeyboardListener keyListener;

  public KeyboardFrame(String name) {
    super(name);

    actionListener = new ButtonListener();
    keyListener = new KeyboardListener();
  }

  public void addComponentsToPane() {
    JButton button = new JButton("Clear");
    button.addActionListener(actionListener);

    typingArea = new JTextField(20);
    typingArea.addKeyListener(keyListener);

    // Uncomment this if you wish to turn off focus
    // traversal.  The focus subsystem consumes
    // focus traversal keys, such as Tab and Shift Tab.
    // If you uncomment the following line of code, this
    // disables focus traversal and the Tab events will
    // become available to the key event listener.
    // typingArea.setFocusTraversalKeysEnabled(false);

    displayArea = new JTextArea();
    displayArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(displayArea);
    scrollPane.setPreferredSize(new Dimension(375, 125));

    getContentPane().add(typingArea, BorderLayout.PAGE_START);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    getContentPane().add(button, BorderLayout.PAGE_END);
  }
}
