class Car {

    private String make;
    private String model;
    private boolean hasSunroof;
    private boolean hasGPS;
    private boolean hasHeatedSeats;

    private Car(CarBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.hasSunroof = builder.hasSunroof;
        this.hasGPS = builder.hasGPS;
        this.hasHeatedSeats = builder.hasHeatedSeats;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    public boolean hasHeatedSeats() {
        return hasHeatedSeats;
    }

    public static class CarBuilder {
        private String make;
        private String model;
        private boolean hasSunroof;
        private boolean hasGPS;
        private boolean hasHeatedSeats;

        public CarBuilder(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public CarBuilder setSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public CarBuilder setGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public CarBuilder setHeatedSeats(boolean hasHeatedSeats) {
            this.hasHeatedSeats = hasHeatedSeats;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

public class Cars {
    public static void main(String[] args) {
        Car myCar = new Car.CarBuilder("Toyota", "Camry")
                .setSunroof(true)
                .setGPS(true)
                .setHeatedSeats(false)
                .build();

        System.out.println("Make: " + myCar.getMake());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Sunroof: " + myCar.hasSunroof());
        System.out.println("GPS: " + myCar.hasGPS());
        System.out.println("Heated Seats: " + myCar.hasHeatedSeats());
    }
}
