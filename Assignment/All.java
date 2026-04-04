import java.time.LocalDateTime;

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountType;

    public BankAccount(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public abstract void accountDetails();
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance, String accountType) {
        super(accountNumber, balance, accountType);
    }

    @Override
    public void accountDetails() {
        System.out.println("Savings Account [Account Number=" + accountNumber + ", Balance=" + balance + ", Type="
                + accountType + "]");
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance, String accountType) {
        super(accountNumber, balance, accountType);
    }

    @Override
    public void accountDetails() {
        System.out.println("Checking Account [Account Number=" + accountNumber + ", Balance=" + balance + ", Type="
                + accountType + "]");
    }
}

class BankAccountFactory {
    public static BankAccount createAccount(String type, String accountNumber, double balance, String accountType) {
        return switch (type) {
            case "Savings" -> new SavingsAccount(accountNumber, balance, accountType);
            case "Checking" -> new CheckingAccount(accountNumber, balance, accountType);
            default -> throw new IllegalArgumentException("Unknown account type: " + type);
        };
    }
}

class LoanApplication {
    private final String applicantName;
    private final double loanAmount;
    private final int termLength;
    private final String collateral;
    private final double interestRate;

    private LoanApplication(LoanApplicationBuilder builder) {
        this.applicantName = builder.applicantName;
        this.loanAmount = builder.loanAmount;
        this.termLength = builder.termLength;
        this.collateral = builder.collateral;
        this.interestRate = builder.interestRate;
    }

    public static class LoanApplicationBuilder {
        private final String applicantName;
        private final double loanAmount;
        private int termLength;
        private String collateral;
        private double interestRate = 0.0;

        public LoanApplicationBuilder(String applicantName, double loanAmount) {
            this.applicantName = applicantName;
            this.loanAmount = loanAmount;
        }

        public LoanApplicationBuilder withTermLength(int termLength) {
            this.termLength = termLength;
            return this;
        }

        public LoanApplicationBuilder withCollateral(String collateral) {
            this.collateral = collateral;
            return this;
        }

        public LoanApplicationBuilder withInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public LoanApplication build() {
            return new LoanApplication(this);
        }
    }

    @Override
    public String toString() {
        return "LoanApplication [Applicant Name=" + applicantName + ", Loan Amount=" + loanAmount +
                ", Term Length=" + termLength + " years, Collateral=" + collateral +
                ", Interest Rate=" + interestRate + "%]";
    }
}

class DatabaseConnection {
    private DatabaseConnection() {
    }

    private static class SingletonHelper {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void connect() {
        System.out.println("Connected to the database.");
        logConnection();
    }

    private void logConnection() {
        System.out.println("Database connection established at " + LocalDateTime.now());
    }
}

public class All {
    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.connect();

        BankAccount savingsAccount = BankAccountFactory.createAccount("Savings", "123456", 1000.00, "Individual");
        BankAccount checkingAccount = BankAccountFactory.createAccount("Checking", "654321", 500.00, "Business");
        savingsAccount.accountDetails();
        checkingAccount.accountDetails();

        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder("Alice", 50000.00)
                .withTermLength(15)
                .withCollateral("House")
                .withInterestRate(3.5)
                .build();
        System.out.println(loanApplication);
    }
}
