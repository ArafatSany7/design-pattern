public class Superheros {
    private String alias;
    private int strength;

    public Superheros(String alias, int strength) {
        this.alias = alias;
        this.strength = strength;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getAlias() {
        return alias;
    }

    public int getStrength() {
        return strength;
    }

    public static void main(String[] args) {
        Superheros hero = new Superheros("Iron Man", 85);

        hero.setAlias("Doctor Strange");
        hero.setStrength(95);

        System.out.println("Alias: " + hero.getAlias());
        System.out.println("Strength: " + hero.getStrength());

    }
}
