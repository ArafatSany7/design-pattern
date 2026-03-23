abstract class Appliance {
    abstract void turnOn();

    abstract void turnOff();
}

class Television extends Appliance {
    @Override
    void turnOn() {
        System.out.println("The television is now ON.");
    }

    @Override
    void turnOff() {
        System.out.println("The television is now OFF.");
    }
}

class WashingMachine extends Appliance {
    @Override
    void turnOn() {
        System.out.println("The washing machine is now ON.");
    }

    @Override
    void turnOff() {
        System.out.println("The washing machine is now OFF.");
    }
}

public class Appliances {
    public static void main(String[] args) {

        Appliance myAppliance = new Television();
        myAppliance.turnOn();
        myAppliance.turnOff();

        myAppliance = new WashingMachine();
        myAppliance.turnOn();
        myAppliance.turnOff();
    }
}
