import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;
import javax.swing.*;

public class PataterSample {

  public static void main(String[] args) {
    try {
      /* Create a new Sythesizer and open it. Most of
       * the methods you will want to use to expand on this
       * example can be found in the Java documentation here:
       * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
       */
      Synthesizer midiSynth = MidiSystem.getSynthesizer();
      midiSynth.open();

      // get and load default instrument and channel lists
      Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
      MidiChannel[] mChannels = midiSynth.getChannels();

      midiSynth.loadInstrument(instr[0]); // load an instrument

      // mChannels[5].noteOn(60, 600);

      JFrame frame = new JFrame("Sound1");
      JPanel pane = new JPanel();
      JButton button1 = new JButton("Click me!");
      frame.getContentPane().add(pane);
      pane.add(button1);
      frame.pack();
      frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
      frame.show();

      button1.addActionListener(
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              mChannels[5].noteOn(60, 600);
            }
          });
    } catch (MidiUnavailableException e) {
    }
  }
}
