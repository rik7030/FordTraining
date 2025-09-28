package Assignment5;

interface MusicPlayer {
    void play(String fileName);

    default void stop() {
        System.out.println("Music stopped");
    }
}

class MP3Player implements MusicPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

class WAVPlayer implements MusicPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}

public class MusicApp {
    public static void main(String[] args) {
        MusicPlayer mp3 = new MP3Player();
        mp3.play("song.mp3");
        mp3.stop();

        MusicPlayer wav = new WAVPlayer();
        wav.play("track.wav");
        wav.stop();
    }
}
