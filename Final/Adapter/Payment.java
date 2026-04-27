// create interface
interface PaymentGateway {

    void pay(double amount);
}

// concrete API class
class WalletApi {

    public void sendPayment(double amount) {
        System.out.println("Payment of " + amount + " processed via wallet");
    }
}

// adapter class
class WalletAdapter implements PaymentGateway {

    private final WalletApi walletApi;

    public WalletAdapter(WalletApi walletApi) {
        this.walletApi = walletApi;
    }

    @Override
    public void pay(double amount) {
        walletApi.sendPayment(amount);
    }
}

public class Payment {

    public static void main(String[] args) {
        PaymentGateway walletPayment = new WalletAdapter(new WalletApi());
        walletPayment.pay(5090);
    }
}
