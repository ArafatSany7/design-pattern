abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void accountType();
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void accountType() {
        System.out.println("This is a Checking Account");
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void accountType() {
        System.out.println("This is a Savings Account");
    }
}

class BankAccountFactory {
    public static BankAccount createAccount(String type, String accountNumber, double balance) {
        switch (type) {
            case "Savings":
                return new SavingsAccount(accountNumber, balance);
            case "Checking":
                return new CheckingAccount(accountNumber, balance);
            default:
                throw new IllegalArgumentException("Unknown account type: " + type);
        }
    }
}

public class Accounts {
    public static void main(String[] args) {
        BankAccount savings = BankAccountFactory.createAccount("Savings", "S123", 1000.0);
        savings.accountType();

        BankAccount checking = BankAccountFactory.createAccount("Checking", "C456", 500.0);
        checking.accountType();
    }
}
