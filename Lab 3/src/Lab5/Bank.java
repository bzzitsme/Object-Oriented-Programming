package Lab5;

import java.util.Vector;

public class Bank {
    private Vector<Account> accounts = new Vector<>();

    void setAccount(Account account) {
        accounts.add(account);
    }

    void setAccounts(Vector<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    void update(double amount) {
        for (Account account : accounts) {
            account.deposit(amount);
            account.withdraw(amount);
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            } else if (account instanceof CheckingAccount) {
                ((CheckingAccount) account).deductFee();
            }
        }
    }

    void openAccount(Account account) {
        accounts.add(account);
    }

    void closeAccount(Account account) {
        accounts.remove(account);
    }
}
