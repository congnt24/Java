import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.*;


public class Play {

	public static void main(String[] args) {
		File soundFile=new File("adios.wav");
		Clip clip;
		try {
			clip=AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			System.out.println("as");
			clip.start();
			System.out.println(soundFile.getPath());
			InputStream in = new FileInputStream(soundFile.getPath());
		    AudioStream audioStream = new AudioStream(in);
			AudioPlayer.player.start(audioStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}

}
