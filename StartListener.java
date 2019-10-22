package musictool;

import java.awt.event.*;
import java.io.File;
import javax.sound.midi.*;
import javax.sound.midi.Sequencer;

public class StartListener implements ActionListener {

  Sequencer midiSequencer;

  public StartListener(Sequencer sequencer) {
    File testMidi = new File("samba.mid");
    Sequence test;

    midiSequencer = sequencer;

    try {
      try {
        test = MidiSystem.getSequence(testMidi);
        midiSequencer.setSequence(test);
      } catch (java.io.IOException e) {
      }
    } catch (InvalidMidiDataException e) {
    }
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Sequencer Start");
    midiSequencer.start();
  }
}
