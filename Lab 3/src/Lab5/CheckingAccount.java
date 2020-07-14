package Lab5;

import java.util.Calendar;

public class CheckingAccount extends Account {
    private int transactionAmount = 0;
    private int freeTransactions = 0;
    private final double fee = 0.02;
    public Calendar calendar = Calendar.getInstance();

    public CheckingAccount() {

    }

    public CheckingAccount(double balance, int accNumber) {
        super(balance, accNumber);
    }

    public void deductFee() {
        if (calendar.get(Calendar.DATE) == 1) {
            super.withdraw(fee * (transactionAmount - freeTransactions));
        }
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionAmount++;
        freeTransactions++;
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionAmount++;
    }

    @Override
    public void transfer(double amount, Account other) {
        super.transfer(amount, other);
        transactionAmount++;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "transactionAmount=" + transactionAmount +
                ", freeTransactions=" + freeTransactions +
                ", fee=" + fee +
                '}';
    }
}
