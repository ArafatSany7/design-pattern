
interface Menu {

    public void Menus();
}

class NonVeg implements Menu {

    @Override
    public void Menus() {
        System.out.println("Non-vegetable");
    }
}

class Veg implements Menu {

    @Override
    public void Menus() {
        System.out.println("Vegetable");
    }
}

class Facade {

    private final Menu NonVeg;
    private final Menu Veg;

    public Facade() {
        this.NonVeg = new NonVeg();
        this.Veg = new Veg();
    }

    public void Vegi() {
        Veg.Menus();
    }

    public void non() {
        NonVeg.Menus();
    }

}

public class Hoteel {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.non();
        facade.Vegi();
    }
}
