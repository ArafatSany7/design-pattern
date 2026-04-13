interface Device {
    void turnOn();
    void turnOff();
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off.");
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned off.");
    }
}

class RemoteControl {
    private Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}

public class Device2{
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl tvRemote = new RemoteControl(tv);
        RemoteControl radioRemote = new RemoteControl(radio);

        tvRemote.turnOn();
        tvRemote.turnOff();

        radioRemote.turnOn();
        radioRemote.turnOff();
    }
}

