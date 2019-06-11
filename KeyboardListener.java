package musictool;

import java.awt.event.*;
import javax.sound.midi.*;

public class KeyboardListener implements KeyListener {

  Synthesizer midiSynth;
  Instrument[] instr;
  MidiChannel[] mChannels;

  public KeyboardListener() {
    try {
      /* documentation here:
       * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
       */
      midiSynth = MidiSystem.getSynthesizer();
      midiSynth.open();
    } catch (MidiUnavailableException e) {
    }
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
