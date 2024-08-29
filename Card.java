import java.util.Objects;

public class Card {
    // Can't change the card number once it's set
    private final String cardNumber;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        // check if the object is compared with itself
        if (this == o) return true;
        // check if the object is null
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        // hash the card number to get a unique hash code
        return Objects.hash(cardNumber);
    }
}
