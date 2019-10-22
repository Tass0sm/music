package musictool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

public class SynthFrame extends JFrame {

  JTextArea displayArea;
  JTextField typingArea;

  KeyboardListener keyListener;

  public SynthFrame(String name, Synthesizer synth) {
    super(name);

    keyListener = new KeyboardListener(synth);
  }

  public void addComponentsToPane() {
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
  }
}
