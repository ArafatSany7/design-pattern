public enum Superhero {
    SUPERMAN(1.0, 100.0),
    BATMAN(0.8, 10.0),
    WONDER_WOMAN(1.2, 50.0),
    FLASH(0.7, 5.0);

    // Declared private final fields for strength and speed
    private final double strength;
    private final double speed;

    // Constructor
    // Completed the implementation for the Superhero constructor
    Superhero(double strength, double speed) {
        this.strength = strength;
        this.speed = speed;
    }

    // Accessor methods
    // Completed the implementation for the strength getter
    public double getStrength() {
        return strength;
    }

    // Completed the implementation for the speed getter
    public double getSpeed() {
        return speed;
    }

    // Defined a method to calculate the power level (as strength * speed)
    public double powerLevel() {
        return strength * speed;
    }

    public static void main(String[] args) {
        for (Superhero hero : Superhero.values()) {
            System.out.println(hero + ": strength = " + hero.getStrength() + ", speed = " + hero.getSpeed()
                    + ", power level = " + hero.powerLevel());
        }

    }
}
