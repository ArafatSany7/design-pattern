public class Calculator {

    public int calculate(int a, int b) {
        return a + b;
    }

    // Calculates base raised to the power of the exponent
    public double calculate(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // Test addition
        System.out.println(calc.calculate(5, 7));

        // Test exponentiation
        System.out.println(calc.calculate(2.0, 3.0));

    }
}
