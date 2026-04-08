interface Beverage {
    String getDescription();
}

class BasicCoffee implements Beverage {
    @Override
    public String getDescription() {
        return "Black Coffee";
    }
}

class BeverageDecorator implements Beverage {
    private Beverage decoratedBeverage;

    public BeverageDecorator(Beverage beverage) {
        this.decoratedBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return decoratedBeverage.getDescription();
    }
}

class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }
}

class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Sugar";
    }
}

public class Suger {
    public static void main(String[] args) {
        Beverage milkCoffee = new MilkDecorator(new BasicCoffee());
        System.out.println(milkCoffee.getDescription());

        Beverage sweetMilkCoffee = new SugarDecorator(new MilkDecorator(new BasicCoffee()));
        System.out.println(sweetMilkCoffee.getDescription());
    }
}
