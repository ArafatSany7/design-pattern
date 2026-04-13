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

class WindowsOS implements OperatingSystem {
    @Override
    public void run(String device) {
        System.out.println("Running " + device + " on Windows OS.");
    }
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



public class Device3 {
    public static void main(String[] args) {
         Device printerOnWindows = new Printer(new WindowsOS());
        printerOnWindows.start(); // Expected Output: Printer: Running Printer on Windows OS.

        // Running a Scanner on MacOS
        Device scannerOnMac = new Scanner(new MacOS());
        scannerOnMac.start(); // Expected Output: Scanner: Running Scanner on MacOS.
    }
}
