public class Gadget {
    private String name;
    private double price;

    public Gadget(String name, double price) {
        this.name = name;
        setPrice(price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price < 50.00) {
            this.price = 50.00;
        } else {
            this.price = price;
        }
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Gadget gadget = new Gadget("Smartphone", 999.99);
        gadget.setName("Laptop");
        gadget.setPrice(49.99);

        System.out.println("Name: " + gadget.getName());
        System.out.println("Price: " + gadget.getPrice());
    }
}
