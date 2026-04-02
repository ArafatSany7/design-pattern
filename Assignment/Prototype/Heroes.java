
abstract class Hero implements Cloneable {

    private final String alias;

    // Constructor
    public Hero(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public abstract Hero cloneHero();

    @Override
    protected Hero clone() throws CloneNotSupportedException {
        return (Hero) super.clone();
    }
}

class FlyingHero extends Hero {

    private final String power;

    // Constructor
    public FlyingHero(String alias, String power) {
        super(alias);
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    @Override
    public Hero cloneHero() {
        // Fetch the alias from the parent class using getAlias() and power from this
        // class
        return new FlyingHero(this.getAlias(), this.power);
    }

    public void showDetails() {

        System.out.println("Hero Alias: " + getAlias() + ", Power: " + this.power);
    }
}

public class Heroes {
    public static void main(String[] args) {

        FlyingHero originalHero = new FlyingHero("SkyDiver", "Super Flight");

        // Casting the returned Hero object back to FlyingHero
        FlyingHero clonedHero = (FlyingHero) originalHero.cloneHero();

        originalHero.showDetails();
        clonedHero.showDetails();

    }
}
