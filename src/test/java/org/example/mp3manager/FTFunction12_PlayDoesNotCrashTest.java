package org.example.mp3manager;

import org.junit.jupiter.api.Test;

class FTFunction12_PlayDoesNotCrashTest {

    @Test
    void playDoesNotCrash() {
        MP3Player player = new MP3Player();
        player.play("non_existing_dummy_path.mp3");
    }
}