class CarRental {
    public void rentCar() {
        System.out.println("Car rented successfully.");
    }
}

 class FlightBooking {
    public void bookFlight() {
        System.out.println("Flight booked successfully.");
    }
}

class HotelBooking {
    public void bookHotel() {
        System.out.println("Hotel booked successfully.");
    }
}
class VacationFacade {
    private FlightBooking flightBooking;
    private HotelBooking hotelBooking;
    private CarRental carRental;

    public VacationFacade() {
        this.flightBooking = new FlightBooking();
        this.hotelBooking = new HotelBooking();
        this.carRental = new CarRental();
    }

    public void bookVacation() {
        flightBooking.bookFlight();
        hotelBooking.bookHotel();
        carRental.rentCar();
        System.out.println("Vacation package booked successfully.");
    }
}


public class Booking {
    public static void main(String[] args) {
        VacationFacade vacationFacade = new VacationFacade();
        vacationFacade.bookVacation();
    }
}
