
class AccountService {

    public void getAccountDetails(String id) {
        System.out.println("Fetching id for account : " + id);
    }
}

class FaundTransfer {

    public void getFundDetails(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferring amount " + amount + " from account " + fromAccount + "to account " + toAccount);
    }
}

class BillPay {

    public void payBill(double amount) {
        System.out.println("Paying bill " + amount);
    }
}

// Facade class here 
class Bankingfacade {

    private AccountService accountService;
    private FaundTransfer faundTransfer;
    private BillPay billPay;

    public Bankingfacade() {
        this.accountService = new AccountService();
        this.faundTransfer = new FaundTransfer();
        this.billPay = new BillPay();
    }

    public void getAccountDetails(String id) {
        accountService.getAccountDetails(id);
    }

    public void getFundDetails(String fromAccount, String toAccount, double amount) {
        faundTransfer.getFundDetails(fromAccount, toAccount, amount);
    }
}

public class Bank {

    public static void main(String[] args) {
        Bankingfacade bankingfacade = new Bankingfacade();
        bankingfacade.getAccountDetails("342342");
        bankingfacade.getFundDetails("34534", "54968743985", 987);
    }
}
