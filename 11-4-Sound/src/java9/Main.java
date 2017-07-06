package java9;

import javax.sound.sampled.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioInputStream stream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResourceAsStream("song.wav"));
        AudioFormat format = stream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(stream);
        clip.start();
    }
}
