public class Card {
    public enum Suit {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }

    public Card(int num, Suit suit) {
        this.num = num;
        this.suit = suit;
    }

    public final int num;
    public final Suit suit;
}
