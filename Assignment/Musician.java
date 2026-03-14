public class Musician {

    private final String name;
    private final String instrument;

    private final int yearsActive;

    public Musician(String name, String instrument, int yearsActive) {
        this.name = name;
        this.instrument = instrument;
        this.yearsActive = yearsActive;
    }

    public void display() {
        System.out.println("Name: " + name + ", Instrument: " + instrument + ", Years Active: " + yearsActive);
    }

    public static void main(String[] args) {
        Musician musician = new Musician("John", "Guitar", 10);
        musician.display();
    }
}
