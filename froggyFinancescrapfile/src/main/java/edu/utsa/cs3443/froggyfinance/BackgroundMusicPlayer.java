package edu.utsa.cs3443.froggyfinance;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * BackgroundMusicPlayer
 *
 * Handles playing background music for the FroggyFinance application.
 * Supports looping playback, volume control, and stopping the music.
 * 
 * Music files should be placed in the `/sounds/` resource folder.
 *
 * author: Sofia Flores
 */
public class BackgroundMusicPlayer {
    /** The audio line used for playback. */
    private static SourceDataLine line;

    /** Thread responsible for playing the audio loop. */
    private static Thread playThread;

    /** Current volume level (0.0 to 1.0). */
    private static float volume = 0.5f;

    private static AudioInputStream ais, din;

    /**
     * Starts looping playback of the specified audio file.
     *
     * This method stops any currently playing music, then begins
     * playing the new file in a continuous loop on a separate daemon thread.
     *
     * @param fileName the name of the audio file in the /sounds/ folder
     */
    public static void playLoop(String fileName) {
        stop();

        playThread = new Thread(() -> {
            try {
                URL url = BackgroundMusicPlayer.class.getResource("/sounds/" + fileName);
                AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                AudioFormat baseFormat = ais.getFormat();
                AudioFormat decodedFormat = new AudioFormat(
                        AudioFormat.Encoding.PCM_SIGNED,
                        baseFormat.getSampleRate(),
                        16,
                        baseFormat.getChannels(),
                        baseFormat.getChannels() * 2,
                        baseFormat.getSampleRate(),
                        false
                );

                AudioInputStream din = AudioSystem.getAudioInputStream(decodedFormat, ais);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
                line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(decodedFormat);
                setVolume(volume);
                line.start();

                byte[] buffer = new byte[4096];
                int bytesRead;

                while (true) { // loop forever
                    while ((bytesRead = din.read(buffer, 0, buffer.length)) != -1) {
                        line.write(buffer, 0, bytesRead);
                    }
                    din.close();
                    ais = AudioSystem.getAudioInputStream(url);
                    din = AudioSystem.getAudioInputStream(decodedFormat, ais);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        playThread.setDaemon(true);
        playThread.start();
    }

    /**
     * Stops any currently playing music.
     *
     * This method closes the audio line and interrupts the playback thread.
     */
    public static void stop() {
        if (din != null) {
            try { din.close(); } catch (IOException ignored) {}
            din = null;
        }
        if (ais != null) {
            try { ais.close(); } catch (IOException ignored) {}
            ais = null;
        }
        if (line != null) {
            line.stop();
            line.close();
            line = null;
        }
        if (playThread != null) {
            playThread.interrupt();
            playThread = null;
        }
    }

    /**
     * Sets the playback volume.
     *
     * The volume is clamped between 0.0 (mute) and 1.0 (full volume).
     * If the audio line supports MASTER_GAIN, the gain is updated
     * immediately.
     *
     * @param vol volume level (0.0 to 1.0)
     */
    public static void setVolume(float vol) {
        volume = Math.max(0f, Math.min(vol, 1f));
        if (line != null && line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gain = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (20 * Math.log10(volume <= 0 ? 0.0001 : volume));
            gain.setValue(dB);
        }
    }

    /**
     * Returns the current volume level.
     *
     * @return the current volume (0.0 to 1.0)
     */
    public static float getVolume() {
        return volume;
    }
}
