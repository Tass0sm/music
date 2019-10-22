package musictool;

import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;
import javax.sound.midi.Sequencer;
import javax.swing.*;

public class Main {

  private static Synthesizer midiSynth;
  private static Sequencer midiSequencer;

  public static void main(String[] args) {

    try {
      /* documentation here:
       * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
       */

      midiSynth = MidiSystem.getSynthesizer();
      midiSequencer = MidiSystem.getSequencer();

      midiSynth.open();
      midiSequencer.open();

    } catch (MidiUnavailableException e) {
    }

    javax.swing.SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            createAndShowGUI();
          }
        });
  }

  private static void createAndShowGUI() {
    SynthFrame frame = new SynthFrame("Synthesizer Frame", midiSynth);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.addComponentsToPane();

    frame.pack();
    frame.setVisible(true);

    SequencerFrame frameTwo = new SequencerFrame("Sequencer Frame", midiSequencer);
    frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frameTwo.addComponentsToPane();

    frameTwo.pack();
    frameTwo.setVisible(true);
  }
}
