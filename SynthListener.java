package musictool;

import java.awt.event.*;
import javax.sound.midi.*;

public class SynthListener implements KeyListener {

  Synthesizer midiSynth;
  Instrument[] instr;
  MidiChannel[] mChannels;

  public SynthListener(Synthesizer synth) {

    midiSynth = synth;

    // get and load default instrument and channel lists
    instr = midiSynth.getDefaultSoundbank().getInstruments();
    mChannels = midiSynth.getChannels();
    midiSynth.loadInstrument(instr[0]); // load an instrument
  }

  /** Handle the key typed event from the text field. */
  public void keyTyped(KeyEvent e) {
    System.out.println("Type");
  }

  /** Handle the key pressed event from the text field. */
  public void keyPressed(KeyEvent e) {
    mChannels[5].noteOn(e.getKeyCode(), 70);
    System.out.println(e.getKeyCode());
  }

  /** Handle the key released event from the text field. */
  public void keyReleased(KeyEvent e) {
    System.out.println("Release");
  }
}
