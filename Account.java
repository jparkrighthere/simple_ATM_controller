public class Account {
    // Can't change the account number once it's set
    private final int accountNumber;
    private int balance;

    public Account(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        // Check if the account has enough balance
        if (amount > this.balance) {
            throw new IllegalArgumentException("INSUFFICIENT FUNDS");
        }
        this.balance -= amount;
    }
}
