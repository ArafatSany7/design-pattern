
interface IBankingService {

    void getAccountDetails(String accountId);

    void getBalanceDetails(int balance);

    void transferFund(String accountId, int balance);
}

class AccountService {

    public void getAccountDetails(String accountId) {
        System.out.println("Fetching account details for ID: " + accountId);
    }
}

class BalanceService {

    public void getBalanceDetails(int balance) {
        System.out.println("Fetching balance details: " + balance);
    }
}

class FundTransferService {

    public void transferFund(String accountId, int balance) {
        System.out.println("Fund transfer from Account: " + accountId + ", amount: " + balance);
    }
}

class BankingFacade implements IBankingService {

    private final AccountService accountService;
    private final BalanceService balanceService;
    private final FundTransferService fundTransferService;

    public BankingFacade() {
        this.accountService = new AccountService();
        this.balanceService = new BalanceService();
        this.fundTransferService = new FundTransferService();
    }

    @Override
    public void getAccountDetails(String accountId) {
        accountService.getAccountDetails(accountId);
    }

    @Override
    public void getBalanceDetails(int balance) {
        balanceService.getBalanceDetails(balance);
    }

    @Override
    public void transferFund(String accountId, int balance) {
        fundTransferService.transferFund(accountId, balance);
    }
}

public class Bank {

    public static void main(String[] args) {
        IBankingService bankingService = new BankingFacade();
        bankingService.getAccountDetails("24135");
        bankingService.getBalanceDetails(9999);
        bankingService.transferFund("3277", 8776);
    }
}
