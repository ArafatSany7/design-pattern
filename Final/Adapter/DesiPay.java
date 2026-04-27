// interface class
interface PaymentWay{
    void Pay(double amount);
}

// Concrete API Adaptee Class
class BkashApi {
    public void bkashPaid(double amount){
        System.out.println("Amount paid "+amount+ " Taka via Bkash");
    }
}

class NagadApi{
    public void nagadPaid(double amount ){
        System.out.println("Amount paid "+amount+ " Via Nagad");
    }
}

class RoketApi{
    public void roketPaid(double amount){
        System.out.println("Amount paid "+amount+ " Via roket");
    }
}


// Concrete Adapter Class implement interface
class BkashAdapter implements PaymentWay{
    private BkashApi bkash;

    public BkashAdapter(BkashApi bkash){
        this.bkash = bkash;
    }

    @Override
    public void Pay(double amount){
        bkash.bkashPaid(amount);
    }
}

class NagadAdapter implements PaymentWay{
    private NagadApi nagad;

    public NagadAdapter(NagadApi nagad){
        this.nagad = nagad;
    }

    @Override
    public void Pay(double amnount){
        nagad.nagadPaid(amnount);
    }
}



public class DesiPay {
    public static void main(String[] args) {
        PaymentWay bkashPay =  new BkashAdapter(new BkashApi());

        bkashPay.Pay(600);
    }
}
