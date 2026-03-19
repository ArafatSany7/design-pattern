class Device {
    private String name;
    private String powerStatus;

    // Initializes the device name and power status
    public Device(String name, String powerStatus) {
        this.name = name;
        this.powerStatus = powerStatus;
    }

    // Prints the base device details (using print instead of println to allow
    // appending)
    public void status() {
        System.out.print("Device: " + name + ", Power: " + powerStatus);
    }
}

class Laptop extends Device {
    private String os;

    // Initializes base fields via super() and the new os attribute
    public Laptop(String name, String powerStatus, String os) {
        super(name, powerStatus);
        this.os = os;
    }

    @Override
    public void status() {
        // Calls the parent method to print name and power, then adds OS details
        super.status();
        System.out.println(", OS: " + os);
    }
}

class Smartphone extends Device {
    private String carrier;

    // Initializes base fields via super() and the new carrier attribute
    public Smartphone(String name, String powerStatus, String carrier) {
        super(name, powerStatus);
        this.carrier = carrier;
    }

    @Override
    public void status() {
        // Calls the parent method to print name and power, then adds Carrier details
        super.status();
        System.out.println(", Carrier: " + carrier);
    }
}

public class Devices {
    public static void main(String[] args) {
        Laptop myLaptop = new Laptop("MacBook Pro", "On", "macOS");

        // Create an instance of Smartphone
        Smartphone myPhone = new Smartphone("iPhone", "Off", "Verizon");

        // Call the status method on both objects
        myLaptop.status();
        myPhone.status();
    }
}
