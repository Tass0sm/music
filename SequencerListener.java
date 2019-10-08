package musictool;

import java.awt.event.*;
import java.io.File;
import javax.sound.midi.*;
import javax.sound.midi.Sequencer;

public class SequencerListener implements ActionListener {

  Sequencer midiSequencer;

  public SequencerListener() {
    File testMidi = new File("samba.mid");
    Sequence test;
    try {
      /* documentation here:
       * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
       */
      midiSequencer = MidiSystem.getSequencer();
      midiSequencer.open();

      // World's Worst Code
      try {
        try {
          test = MidiSystem.getSequence(testMidi);
          midiSequencer.setSequence(test);
        } catch (java.io.IOException e) {
        }
      } catch (InvalidMidiDataException e) {
      }
    } catch (MidiUnavailableException e) {
    }
    // sequence = midiSequencer.getSynthesizer
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Sequencer Start");
    midiSequencer.start();
  }
}
