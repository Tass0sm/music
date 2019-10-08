package musictool;

import java.awt.BorderLayout;
import javax.swing.*;

public class SequencerFrame extends JFrame {

  SequencerListener startListener;
  ButtonListener stopListener;

  public SequencerFrame(String name) {
    super(name);

    startListener = new SequencerListener();
    stopListener = new ButtonListener();
  }

  public void addComponentsToPane() {
    JButton startButton = new JButton("Start");
    startButton.addActionListener(startListener);

    JButton stopButton = new JButton("Stop");
    stopButton.addActionListener(stopListener);

    // Uncomment this if you wish to turn off focus
    // traversal.  The focus subsystem consumes
    // focus traversal keys, such as Tab and Shift Tab.
    // If you uncomment the following line of code, this
    // disables focus traversal and the Tab events will
    // become available to the key event listener.
    // typingArea.setFocusTraversalKeysEnabled(false);

    getContentPane().add(startButton, BorderLayout.EAST);
    getContentPane().add(stopButton, BorderLayout.PAGE_END);
  }
}
