
class ATMRequest {

    String cardNumber, pin;
    double balance;

    public ATMRequest(String cardNumber, String pin, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

}
// interface handler

interface ATMHandler {

    void handle(ATMRequest request);

    void sendNext(ATMHandler nextATMHandler);
}

// parent class
abstract class BaseHandler implements ATMHandler{
    protected ATMHandler next;
    @Override
    public void sendNext(ATMHandler nextATMHandler){
        this.next = nextATMHandler;
    }
    protected void forward(ATMRequest request){
        if(next != null){
            next.handle(request);
        }else{
            System.out.println("Authorization pass");
        }
    }
}

// child class
class CardValidatorHandler extends BaseHandler{

    @Override
    public void handle(ATMRequest request){
        if(request.cardNumber == null){
            System.out.println("Invalid");
        }else{
            System.out.println("card Validated");
            forward(request);
        }
    }
}

class PinValidatorHandler extends BaseHandler{
    @Override
    public void handle(ATMRequest request){
        if(!"124".equals(request.pin)){
            System.out.println("Incorrect pin");
        }else{
            System.out.println("pin success");
            forward(request);
        }
    }
}

class BalanceHandler extends BaseHandler{

    @Override
    public void handle(ATMRequest request){
        if(request.balance < 100){
            System.out.println("insufficient balance");
        }else{
            System.out.println("balance");
        }
    }
}

public class ATM {

    public static void main(String[] args) {
        ATMHandler card = new CardValidatorHandler();
        ATMHandler pin  = new PinValidatorHandler();
        ATMHandler balance = new BalanceHandler();

        card.sendNext(pin);
        pin.sendNext(balance);

        ATMRequest request = new ATMRequest("ertert", "345f5343", 98);
        card.handle(request);
    }
}
