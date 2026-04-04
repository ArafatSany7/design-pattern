interface MediaPlayer {
    void playAudio(String filename);
}

class VLCPlayer {
    public void playVLCFile(String filename) {
        System.out.println("Playing VLC file: " + filename);
    }
}

class MediaPlayerAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer;

    public MediaPlayerAdapter(VLCPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    @Override
    public void playAudio(String filename) {
        vlcPlayer.playVLCFile(filename);
    }
}

public class MediaPlayers {
    public static void main(String[] args) {
        VLCPlayer vlcPlayer = new VLCPlayer();
        MediaPlayer adapter = new MediaPlayerAdapter(vlcPlayer);
        adapter.playAudio("test_audio.vlc");
    }
}
