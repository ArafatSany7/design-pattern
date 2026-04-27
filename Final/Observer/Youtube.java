
import java.util.*;

// Prothonme ekta observer interface 
interface Observer {

    void update(String channelName, String videoTittle);
}

// Now create Subject interface , eita observer add remove notify er kaj korbe
// subject observer er jei jei variable Observer er sathe mile tar data type hobe first interface 
interface Subject {

    void addObserver(Observer userName);

    void removeObserver(Observer userName);

    void notifyObserver(String message);
}

// Concrete Subject Class subject ke impliments korbe
class YoutubeChannel implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String channelName;
    private String latestVideo;

    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void addObserver(Observer userName) {
        observers.add(userName);
    }

    @Override
    public void removeObserver(Observer userName) {
        observers.remove(userName);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer userName : observers) {
            userName.update(channelName, latestVideo);
        }
    }

    public void latestVideo(String videoTitle) {
        this.latestVideo = videoTitle;
        notifyObserver(videoTitle);
    }
}

// for subscriber class
class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String channelName, String videoTittle) {
        System.out.println(name + "Got notifivastion for " + videoTittle);
    }
}

class buttonPress implements Observer {

    private String name;
    private boolean bell;

    public buttonPress(String name, boolean bell) {
        this.bell = bell;
        this.name = name;
    }

    public void update(String chanmelName , String videoTittle) {
        if (bell) {
            System.out.println(name + "........" + videoTittle);
        }
    }
}

public class Youtube {

    public static void main(String[] args) {

        //  prothome Youtube banaite hobe
        YoutubeChannel channel = new YoutubeChannel("NOG");

        // tarpor user add korte hobe
        Observer user1 = new Subscriber("sany");

        // tarpor oi user der jonno kaj
        channel.addObserver(user1);
        channel.latestVideo("Vlog420");
        channel.notify();
    }
}
