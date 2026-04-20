
interface Pizza {

    String getDescription();

    double cost();
}

class plainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double cost() {
        return 8.0;
    }
}

abstract class pizzaDecorator implements Pizza {

    protected Pizza decoratedPizza;

    public pizzaDecorator(Pizza decoratePizza) {
        this.decoratedPizza = decoratePizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    public double cost() {
        return decoratedPizza.cost();
    }
}

class cheeseDecorator extends pizzaDecorator{

    public cheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    @Override
    public String getDescription(){
        return decoratedPizza.getDescription()+",Cheese";
    }

    @Override
    public double cost(){
        return decoratedPizza.cost() + 1.5;
    }
}

public class Pizzas {

    public static void main(String[] args) {
        Pizza pizza = new plainPizza();
        pizza = new cheeseDecorator(pizza);
        System.out.println(pizza.getDescription()+" $" + pizza.cost());
    }
}
