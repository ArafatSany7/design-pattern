abstract class Prototype implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class CustomerProfile extends Prototype {
    private String customerName;
    private String address;
    private String accountNumber;

    public CustomerProfile(String customerName, String address, String accountNumber) {
        this.customerName = customerName;
        this.address = address;
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "CustomerProfile [Name=" + customerName + ", Address=" + address + ", Account Number=" + accountNumber
                + "]@" + Integer.toHexString(hashCode());
    }
}

public class Profiles {
    public static void main(String[] args) {
        try {
            CustomerProfile original = new CustomerProfile("John Doe", "123 Java Lane", "987654321");

            CustomerProfile cloned = (CustomerProfile) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Cloned:   " + cloned);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
