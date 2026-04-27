
interface Coffee {

    String getDescription();

    double getCost();
}

// Base class here implements interface coffee
class PlainCoffee implements Coffee {

    String coffee;
    double cost;

    public PlainCoffee(String coffee, double cost) {
        this.coffee = coffee;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return coffee;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

// Basic decorator class here, abstract class and implements the interface
abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee ;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}

// Concrete decorator class here extend basic decorator
class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return "Milk " + coffee.getDescription() + " selected";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 1.50;
    }
}

public class Task5 {

    public static void main(String[] args) {
        Coffee cafe =  new PlainCoffee("Cafe Espresso", 5);

        System.out.println("Basic coffee: " + cafe.getDescription());
        System.out.println("Basic coffee price: $" + cafe.getCost());

        Coffee milkCoffee = new MilkDecorator(cafe);
        System.out.println(milkCoffee.getDescription());
        System.out.println("Price of coffee is extended to $" + milkCoffee.getCost());
    }
}
