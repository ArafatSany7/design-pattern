interface VehicleAbstractFactory {

    Vehicle createVehicle();
}

abstract class Vehicle {

    public abstract void drive();
}

class BikeFactory implements VehicleAbstractFactory {
    @Override

    public Vehicle createVehicle() {
        return new Bike();
    }
}

class CarFactory implements VehicleAbstractFactory {
    @Override

    public Vehicle createVehicle() {
        return new Car();
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(VehicleAbstractFactory factory) {
        return factory.createVehicle();
    }
}

class Bike extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

public class Vehicles {
    public static void main(String[] args) {

        Vehicle car = VehicleFactory.createVehicle(new CarFactory());
        car.drive();

        Vehicle bike = VehicleFactory.createVehicle(new BikeFactory());
        bike.drive();
    }
}
