class SoundSystem {
    public void start() {
        System.out.println("Sound system is starting...");
    }

    public void playSound() {
        System.out.println("Sound system playing is audio...");
    }

    public void stop() {
        System.out.println("Sound system stopped.");
    }
}

class Projector {
    public void turnOn() {
        System.out.println("Projector turning on...");
    }

    public void display() {
        System.out.println("Projector displaying video...");
    }

    public void turnOff() {
        System.out.println("Projector turning off.");
    }
}

class Lights {
    public void dim() {
        System.out.println("Lights dimming...");
    }

    public void brighten() {
        System.out.println("Lights brightening...");
    }
}

class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade() {
        this.projector = new Projector();
        this.soundSystem = new SoundSystem();
        this.lights = new Lights();
    }

    public void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        lights.dim();
        projector.turnOn();
        projector.display();
        soundSystem.start();
        soundSystem.playSound();
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        soundSystem.stop();
        projector.turnOff();
        lights.brighten();
    }
}


public class Home {
    public static void main(String[] args) {
         HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie();
        System.out.println("-------------------------");
        homeTheater.endMovie();
    }
}
