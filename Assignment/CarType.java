public enum CarType {
    SEDAN(1500, 190),
    SUV(2000, 180),
    TRUCK(3000, 120),
    COUPE(1400, 220),
    // Added SPORTS and moved the semicolon to the end of the list
    SPORTS(1200, 300);

    private final double weight; // in kilograms
    private final double topSpeed; // in km/h

    // Constructor
    CarType(double weight, double topSpeed) {
        this.weight = weight;
        this.topSpeed = topSpeed;
    }

    // Accessor methods
    public double getWeight() {
        return weight;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    // Calculate the acceleration of the car
    public double acceleration() {
        final double accelerationFactor = 2.0; // arbitrary constant for example
        return topSpeed / (weight * accelerationFactor);
    }

    // Main method moved inside the CarType enum
    public static void main(String[] args) {
        // Iterated over the CarType values using an enhanced for-loop
        for (CarType car : CarType.values()) {

            System.out.println(car + ": weight = " + car.getWeight() +
                    ", top speed = " + car.getTopSpeed() +
                    ", acceleration = " + car.acceleration());
        }
    }
}
