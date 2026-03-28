// Define an abstract class Instrument with a method called play
abstract class Instrument {
    public abstract void play();
}

// Create a class Guitar that extends Instrument and implements the play method
class Guitar extends Instrument {
    @Override
    public void play() {
        System.out.println("Strumming the Guitar: Strum strum...");
    }
}

// Create a class Piano that extends Instrument and implements the play method
class Piano extends Instrument {
    @Override
    public void play() {
        System.out.println("Playing the Piano: Plink plonk...");
    }
}

// Create a class NullInstrument that extends Instrument and implements the play
// method
// This implements the Null Object Pattern to gracefully handle unsupported
// inputs
class NullInstrument extends Instrument {
    @Override
    public void play() {
        System.out.println("Silence... (Unsupported or unknown instrument)");
    }
}

// Create a class InstrumentFactory with an enum for InstrumentType
class InstrumentFactory {

    public enum InstrumentType {
        GUITAR, PIANO, DRUMS // 'DRUMS' is here to test the unsupported default case
    }

    // Add a factory method to create instruments based on the type
    public static Instrument createInstrument(InstrumentType type) {
        // Handle null input right away
        if (type == null) {
            return new NullInstrument();
        }

        // Use a switch statement to handle the creation logic
        switch (type) {
            case GUITAR:
                return new Guitar();
            case PIANO:
                return new Piano();
            default:
                // Return a NullInstrument instance for unsupported types
                return new NullInstrument();
        }
    }
}

public class Instuments {
    public static void main(String[] args) {
        System.out.println("--- Testing Instrument Factory ---");

        // Use the InstrumentFactory to create a Guitar and call the play method
        Instrument guitar = InstrumentFactory.createInstrument(InstrumentFactory.InstrumentType.GUITAR);
        guitar.play();

        // Use the InstrumentFactory to create a Piano and call the play method
        Instrument piano = InstrumentFactory.createInstrument(InstrumentFactory.InstrumentType.PIANO);
        piano.play();

        // Use the InstrumentFactory to create an unsupported instrument (DRUMS) and
        // call play
        Instrument unsupported = InstrumentFactory.createInstrument(InstrumentFactory.InstrumentType.DRUMS);
        unsupported.play();

        // Use the InstrumentFactory to create a null instrument and call the play
        // method
        Instrument nullInstrument = InstrumentFactory.createInstrument(null);
        nullInstrument.play();
    }
}
