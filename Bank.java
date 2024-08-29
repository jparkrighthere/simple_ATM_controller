import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Card, Integer> cardPinMap;
    private Map<Integer, Account> accountMap;

    public Bank() {
        cardPinMap = new HashMap<>();
        accountMap = new HashMap<>();
    }

    public void addCard(Card card, int pin) {
        cardPinMap.put(card, pin);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public boolean authenticate(Card card, int pin) {
        return cardPinMap.getOrDefault(card, -1) == pin;
    }

    public Account getAccount(int accountNumber) {
        return accountMap.get(accountNumber);
    }

    public boolean isCardValid(Card card) {
        return cardPinMap.containsKey(card);
    }
}

