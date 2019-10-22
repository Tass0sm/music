package musictool;

import java.awt.event.*;
import javax.sound.midi.*;
import javax.sound.midi.Sequencer;

public class StopListener implements ActionListener {

  Sequencer midiSequencer;

  public StopListener(Sequencer sequencer) {
    midiSequencer = sequencer;
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Sequencer Stop");
    midiSequencer.stop();
  }
}
