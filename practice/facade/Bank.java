
class AccountService {

    public void getAccountDetails(String accountID) {
        System.out.println("Fetching Account details for ID : " + accountID);
    }
}

class BallanceService {

    public void getBalanceDetails(int balance) {
        System.out.println("Fetching Account details for ID : " + balance);
    }
}

class FundTransfer {

    public void transferFund(String accountId, int balance) {
        System.out.println("Fund transfer from Account : " + accountId + " And the balance is : " + balance);
    }
}

class BankingFacade {

    private final AccountService accountService;
    private final BallanceService ballanceService;
    private final FundTransfer fundTransfer;

    public BankingFacade(){
        this.accountService = new AccountService();
        this.ballanceService = new BallanceService();
        this.fundTransfer = new FundTransfer();
    }

    public void getAccountDetails(String accountID){
        accountService.getAccountDetails(accountID);
    }

    public void getBalanceDetails(int balance){
        ballanceService.getBalanceDetails(balance);
    }
    public void transferFund(String accountID , int balance){
        fundTransfer.transferFund(accountID, balance);
    }

}

public class Bank {

    public static void main(String[] args) {

        BankingFacade bankingFacade = new BankingFacade();
        bankingFacade.getAccountDetails("24135" );
        bankingFacade.getBalanceDetails(9999);
        bankingFacade.transferFund("3277", 8776);
    }
}
