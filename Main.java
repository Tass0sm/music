package musictool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            createAndShowGUI();
          }
        });
  }

  private static void createAndShowGUI() {
    KeyboardFrame frame = new KeyboardFrame("Keyboard Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.addComponentsToPane();

    frame.pack();
    frame.setVisible(true);
  }
}
