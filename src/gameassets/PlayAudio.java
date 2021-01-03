package gameassets;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class PlayAudio {
    private final String name;
    public boolean isMuted;
    private Clip clip;
    private FloatControl gainControl;

    public PlayAudio(String name) {
        this.name = name;
    }

    public void play(boolean loop) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(Constants.SOUND_DIR + name).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void setVolume(float volume) {
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * volume) + gainControl.getMinimum();
        gainControl.setValue(gain);
    }

    public void stop() {
        clip.stop();
        isMuted = true;
    }

    public void resume() {
        clip.start();
        isMuted = false;
    }

    public void close() {
        clip.close();
    }
}
