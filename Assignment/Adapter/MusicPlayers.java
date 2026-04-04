interface MusicPlayer {
    void playMusic();
}

class CDPlayer {
    public void playCD() {
        System.out.println("Playing music from CD.");
    }
}

class MusicAdapter implements MusicPlayer {
    private CDPlayer cdPlayer;

    public MusicAdapter(CDPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    @Override
    public void playMusic() {
        cdPlayer.playCD();
    }
}

public class MusicPlayers {
    public static void main(String[] args) {
        CDPlayer cdPlayer = new CDPlayer();
        MusicPlayer adapter = new MusicAdapter(cdPlayer);
        adapter.playMusic();
    }
}
