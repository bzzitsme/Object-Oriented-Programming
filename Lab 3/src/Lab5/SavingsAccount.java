package Lab5;

public class SavingsAccount extends Account {
    double interestRate = 1.13;

    public SavingsAccount() {

    }

    public SavingsAccount(double balance, int accNumber) {
        super(balance, accNumber);
    }

    public void addInterest() {
        super.deposit(super.getBalance() * interestRate);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                '}';
    }
}
