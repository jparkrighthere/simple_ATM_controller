public class ATM {
    private Bank bank;
    private Card card;
    private boolean cardInserted;
    private boolean authenticated;
    private Account currentAccount;

    public ATM(Bank bank) {
        this.bank = bank;
        this.cardInserted = false;
        this.authenticated = false;
    }

    public void insertCard(Card card) {
        if (!bank.isCardValid(card)) {
            throw new IllegalStateException("INVALID CARD");
        }
        this.card = card;
        this.cardInserted = true;
    }

    public boolean enterPIN(int pin) {
        if (!cardInserted) {
            throw new IllegalStateException("NO CARD INSERTED");
        }
        authenticated = bank.authenticate(card, pin);
        return authenticated;
    }

    public void selectAccount(int accountNumber) {
        if (!authenticated) {
            throw new IllegalStateException("USER NOT AUTHENTICATED");
        }
        currentAccount = bank.getAccount(accountNumber);
    }

    public int checkBalance() {
        if (currentAccount == null) {
            throw new IllegalStateException("NO ACCOUNT SELECTED");
        }
        return currentAccount.getBalance();
    }

    public void deposit(int amount) {
        if (currentAccount == null) {
            throw new IllegalStateException("NO ACCOUNT SELECTED");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("INVALID DEPOSIT AMOUNT");
        }
        currentAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        if (currentAccount == null) {
            throw new IllegalStateException("NO ACCOUNT SELECTED");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("INVALID WITHDRAWAL AMOUNT");
        }
        currentAccount.withdraw(amount);
    }
}
