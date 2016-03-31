package slot;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.

public class SoundClipTest extends JFrame {

	// Constructor
	public SoundClipTest() {
		// TODO Auto-generated constructor stub
	}

	public void SoundClipTest(String title) {
		// TODO Auto-generated method stub
		try {
			// Open an audio input stream.
			// File soundFile = new File(); //you could also get the sound file
			// with an URL
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(title));
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
}