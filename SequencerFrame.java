package musictool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.sound.midi.Sequencer;
import javax.swing.*;

public class SequencerFrame extends JFrame {

  StartListener startListener;
  StopListener stopListener;

  JTextArea displayArea;

  public SequencerFrame(String name, Sequencer sequencer) {
    super(name);

    startListener = new StartListener(sequencer);
    stopListener = new StopListener(sequencer);
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

    displayArea = new JTextArea();
    displayArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(displayArea);
    scrollPane.setPreferredSize(new Dimension(375, 125));

    getContentPane().add(startButton, BorderLayout.PAGE_START);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    getContentPane().add(stopButton, BorderLayout.PAGE_END);
  }
}
