
interface OperatingSystem {

    void run(String device);
}

abstract class Device {

    protected OperatingSystem os;

    public Device(OperatingSystem os) {
        this.os = os;
    }

    public abstract void start();
}

class MacOS implements OperatingSystem {

    @Override
    public void run(String device) {
        System.out.println("Running " + device + " on MacOS.");
    }
}

class Printer extends Device {

    public Printer(OperatingSystem os) {
        super(os);
    }

    @Override
    public void start() {
        System.out.print("Printer: ");
        os.run("Printer");
    }
}

class Scanner extends Device {

    public Scanner(OperatingSystem os) {
        super(os);
    }

    @Override
    public void start() {
        System.out.print("Scanner: ");
        os.run("Scanner");
    }
}

class WindowsOS implements OperatingSystem {

    @Override
    public void run(String device) {
        System.out.println("Running " + device + " on Windows OS.");
    }
}

public class Devices {

    public static void main(String[] args) {
        Device printerOnMac = new Printer(new MacOS());
        Device scannerOnWindows = new Scanner(new WindowsOS());

        printerOnMac.start();
        scannerOnWindows.start();
    }
}
