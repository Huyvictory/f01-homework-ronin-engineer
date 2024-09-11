package Assignment10;

import Assignment10.Exceptions.InsufficientFundsException;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance)
            throw new InsufficientFundsException(amount + " is greater than balance " + balance);
        balance -= amount;
    }
}
