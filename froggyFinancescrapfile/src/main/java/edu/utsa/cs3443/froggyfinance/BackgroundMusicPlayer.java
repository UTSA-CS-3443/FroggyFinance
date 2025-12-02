package edu.utsa.cs3443.froggyfinance;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class BackgroundMusicPlayer {
    private static SourceDataLine line;
    private static Thread playThread;
    private static float volume = 0.5f;

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

    public static void stop() {
        if (line != null) {
            line.stop();
            line.close();
        }
        if (playThread != null) {
            playThread.interrupt();
        }
    }

    public static void setVolume(float vol) {
        volume = Math.max(0f, Math.min(vol, 1f));
        if (line != null && line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gain = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (20 * Math.log10(volume <= 0 ? 0.0001 : volume));
            gain.setValue(dB);
        }
    }

    public static float getVolume() {
        return volume;
    }
}
