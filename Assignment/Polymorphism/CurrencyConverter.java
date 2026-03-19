public class CurrencyConverter {
    // Converts the amount using a default rate of 0.84
    public double convert(double amount) {
        return amount * 0.84;
    }

    // Overloaded convert method that takes amount and rate as parameters
    public double convert(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        // Creating an instance of the CurrencyConverter class
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println(converter.convert(100)); // Should Output: 84.0

        System.out.println(converter.convert(100, 1.39)); // Should Output: 139.0
    }
}
