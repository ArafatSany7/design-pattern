
class DeviceDecorator implements Device {
    private Device decoratedDevice;

    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }

    @Override
    public String specs() {
        return decoratedDevice.specs();
    }
}

interface Device {
    String specs();
}

class CameraModule extends DeviceDecorator {
    public CameraModule(Device device) {
        super(device);
    }

    @Override
    public String specs() {
        return super.specs() + " + High-Resolution Camera";
    }
}

class BatteryBooster extends DeviceDecorator {
    public BatteryBooster(Device device) {
        super(device);
    }

    @Override
    public String specs() {
        return super.specs() + " + Enhanced Battery Life";
    }
}

class BasicSmartphone implements Device {
    @Override
    public String specs() {
        return "Basic Smartphone";
    }
}

public class Battary {
    public static void main(String[] args) {
        Device cameraPhone = new CameraModule(new BasicSmartphone());
        System.out.println(cameraPhone.specs());

        Device batteryPhone = new BatteryBooster(new BasicSmartphone());
        System.out.println(batteryPhone.specs());
    }
}
