package org.example.mp3manager;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * A simple class to play mp3 files
 */
public class MP3Player {

    private boolean stopped = false;

    // forward references to inner classes
    MP3Thread playerThread = null;

    /**
     *  an inner class to play an mp3 file inside a Java thread
     */
    private class MP3Thread extends Thread {
        private String mp3filename;
        private Player player;

        public MP3Thread(String filename) {
            super("Playing " + filename);
            mp3filename = filename;
        }

        public void close() {
            if (player != null)
                player.close();
        }

        public void run() {
            try {
                FileInputStream fis = new FileInputStream(mp3filename);
                BufferedInputStream bis = new BufferedInputStream(fis);

                player = new Player(bis);
                player.play();
                if (!stopped)
                    System.out.println("MP3Player: playback finished");
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("MP3Player: Cannot play: " + mp3filename);
            }
        }
    }

    // Play a given file
    public void play(String filename) {
        stopped = false;
        playerThread = new MP3Thread(filename);
        playerThread.start();
        System.out.println("MP3Player: file " + filename + " is playing");
    }
}