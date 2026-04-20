interface orderTask{
    void execute(String productId , double amount);
}

class CheckInventory implements orderTask{
    @Override
    public void execute(String productId , double amount){
        System.out.println("Product " + productId + "Is available and price is " + amount);
    }
}

class CalculateAmount implements orderTask{
    @Override
    public void execute(String productId , double amount){
        System.out.println("Total Amount is "+amount+" Taka");
    }
}
class PaymentConfirmation implements orderTask{
    @Override
    public void execute(String productId ,  double amount ){
        System.out.println("Payment tk " + amount + " Has confirmed for product id "+ productId);
    }
}

class orderFacade {
    private final orderTask inventory;
    private final orderTask calculate;
    private final orderTask payment;

    public orderFacade(){
        this.calculate =  new CalculateAmount();
        this.inventory  =  new CheckInventory();
        this.payment =  new PaymentConfirmation();
    }

    public void placeOrder(String productID ,  double amount){
        inventory.execute(productID, amount);
        payment.execute(productID, amount);
        calculate.execute(productID, amount);
    }
}
public class Ecommerce {
    public static void main(String[] args) {
        orderFacade facade = new orderFacade();

        facade.placeOrder("357678", 876);
    }
}
