
import java.util.*;

interface Observer {

    void update(String classRoutine, String examRoutine);
}

interface Subject {

    void addSubscriber(Observer userName);

    void removeSubscriber(Observer userName);

    void notifyObserver(String message);
}

class NotificationSystem implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private String latestNotification;
    private final String name;

    public NotificationSystem(String name){
        this.name = name;
    }

    @Override
    public void addSubscriber(Observer userName) {
        observers.add(userName);
    }

    @Override
    public void removeSubscriber(Observer userName) {
        observers.remove(userName);
    }

    @Override
    public void notifyObserver(String message) {
        this.latestNotification = message;
        for (Observer userName : observers) {
            userName.update(message, message);
        }
    }
}

class Subscriber implements Observer{
    private String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void update(String classRoutine, String examRoutine){
        System.out.println("Routine updated for " + name);
    }
}


public class Task3 {

    public static void main(String[] args) {
       NotificationSystem notice = new NotificationSystem("Routine");

       Observer Student = new Subscriber("Sany");
       notice.addSubscriber(Student);
       notice.notifyObserver("Class routine updated");
    }
}
