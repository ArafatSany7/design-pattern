interface MusicFileAbstractFactory {
    // Declare the abstract method createMusicFile()
    MusicFile createMusicFile();
}

class FLACFileFactory implements MusicFileAbstractFactory {
    @Override
    // Implement the createMusicFile method to return a new FLACFile instance
    public MusicFile createMusicFile() {
        return new FLACFile();
    }
}

class MusicFileFactory {
    // Implement the createMusicFile method to utilize a factory to create a music
    // file
    public static MusicFile createMusicFile(MusicFileAbstractFactory factory) {
        return factory.createMusicFile();
    }
}

// Define WAVFileFactory class which implements MusicFileAbstractFactory
class WAVFileFactory implements MusicFileAbstractFactory {
    @Override
    // Implement the createMusicFile method to return a new WAVFile instance
    public MusicFile createMusicFile() {
        return new WAVFile();
    }
}

// Define MP3FileFactory class which implements MusicFileAbstractFactory
class MP3FileFactory implements MusicFileAbstractFactory {
    @Override
    // Implement the createMusicFile method to return a new MP3File instance
    public MusicFile createMusicFile() {
        return new MP3File();
    }
}

class FLACFile extends MusicFile {
    @Override
    // Implement the play method to print "Playing FLAC File."
    public void play() {
        System.out.println("Playing FLAC File.");
    }
}

// Define WAVFile class which extends MusicFile
class WAVFile extends MusicFile {
    @Override
    // Implement the play method to print "Playing WAV File."
    public void play() {
        System.out.println("Playing WAV File.");
    }
}

// Define MP3File class which extends MusicFile
class MP3File extends MusicFile {
    @Override
    // Implement the play method to print "Playing MP3 File."
    public void play() {
        System.out.println("Playing MP3 File.");
    }
}

// Define the abstract class MusicFile with an abstract play method
abstract class MusicFile {
    // Declare the abstract method play()
    public abstract void play();
}

public class Musics {
    public static void main(String[] args) {
        MusicFile mp3 = MusicFileFactory.createMusicFile(new MP3FileFactory());
        mp3.play();

        // Create a WAV File
        MusicFile wav = MusicFileFactory.createMusicFile(new WAVFileFactory());
        wav.play();

        // Create a FLAC File
        MusicFile flac = MusicFileFactory.createMusicFile(new FLACFileFactory());
        flac.play();
    }
}
