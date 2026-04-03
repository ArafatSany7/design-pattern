abstract class Loan {
    protected double interestRate;
    protected double loanAmount;

    public Loan(double interestRate, double loanAmount) {
        this.interestRate = interestRate;
        this.loanAmount = loanAmount;
    }

    public abstract void loanDetails();
}

class HomeLoan extends Loan {
    public HomeLoan(double interestRate, double loanAmount) {
        super(interestRate, loanAmount);
    }

    @Override
    public void loanDetails() {
        System.out.println("Home Loan Details: Amount = " + loanAmount + ", Interest Rate = " + interestRate + "%");
    }
}

class CarLoan extends Loan {
    public CarLoan(double interestRate, double loanAmount) {
        super(interestRate, loanAmount);
    }

    @Override
    public void loanDetails() {
        System.out.println("Car Loan Details: Amount = " + loanAmount + ", Interest Rate = " + interestRate + "%");
    }
}

interface LoanFactory {
    Loan createLoan(double interestRate, double loanAmount);
}

class HomeLoanFactory implements LoanFactory {
    @Override
    public Loan createLoan(double interestRate, double loanAmount) {
        return new HomeLoan(interestRate, loanAmount);
    }
}

class CarLoanFactory implements LoanFactory {
    @Override
    public Loan createLoan(double interestRate, double loanAmount) {
        return new CarLoan(interestRate, loanAmount);
    }
}

class LoanApplication {
    public Loan applyForLoan(LoanFactory factory, double interestRate, double loanAmount) {
        return factory.createLoan(interestRate, loanAmount);
    }
}

public class Loans {
    public static void main(String[] args) {
        LoanApplication app = new LoanApplication();

        Loan homeLoan = app.applyForLoan(new HomeLoanFactory(), 3.5, 250000.0);
        Loan carLoan = app.applyForLoan(new CarLoanFactory(), 5.2, 35000.0);

        homeLoan.loanDetails();
        carLoan.loanDetails();
    }
}
