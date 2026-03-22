abstract class Device {
    private double powerRating;

    public Device(double powerRating) {
        this.powerRating = powerRating;
    }

    public abstract double usageHours();

    public double calculatePowerConsumption() {
        return powerRating * usageHours();
    }
}

class Laptop extends Device {
    private double dailyUsage;

    public Laptop(double powerRating, double dailyUsage) {
        super(powerRating);
        this.dailyUsage = dailyUsage;
    }

    @Override
    public double usageHours() {
        return dailyUsage;
    }
}

class Smartphone extends Device {
    private double dailyUsage;

    public Smartphone(double powerRating, double dailyUsage) {
        super(powerRating);
        this.dailyUsage = dailyUsage;
    }

    @Override
    public double usageHours() {
        return dailyUsage;
    }
}

public class Devices {
    public static void main(String[] args) {

        Laptop laptop = new Laptop(50, 5);
        Smartphone smartphone = new Smartphone(10, 3);

        System.out.println(laptop.calculatePowerConsumption());
        System.out.println(smartphone.calculatePowerConsumption());
    }
}
