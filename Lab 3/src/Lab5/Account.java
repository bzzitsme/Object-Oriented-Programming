package Lab5;

public class Account {
    private double balance;
    private int accNumber;

    public Account() {

    }

    public Account(double balance, int accNumber) {
        this.balance = balance;
        this.accNumber = accNumber;
    }

    public Account(int accNumber) {
        balance = 0.0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        balance += (sum > 0) ? sum : 0;
        System.out.println((sum > 0) ? sum + " has been added to your balance" : "Deposit sum must be positive amount");
    }

    public void withdraw(double sum) {
        balance -= (this.balance >= sum) ? sum : 0;
        System.out.println((this.balance >= sum) ? "You withdrawed " + sum + " from your Account" : "You don't have enought balance to withdraw");
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAccountNumber() {
        return this.accNumber;
    }

    public void transfer(double amount, Account other) {
        withdraw(amount);
        other.deposit(amount);
        System.out.println((this.balance >= amount) ? "You successfully transferred " + amount + " to " + other.getAccountNumber() : "You don't have enought amount to transfer");
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accNumber=" + accNumber +
                '}';
    }

    public final void print() {
        System.out.println(toString());
    }
}
