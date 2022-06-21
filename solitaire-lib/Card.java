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

    @Override
    public String toString() {
        String str;
        switch (num) {
        case 1:
            str = "A";
            break;
        case 10:
            str = "X";
            break;
        case 11:
            str = "J";
            break;
        case 12:
            str = "Q";
            break;
        case 13:
            str = "K";
            break;
        default:
            str = Integer.toString(num);
            break;
        }
        switch (suit) {
        case SPADES:
            str += "S";
            break;
        case HEARTS:
            str += "H";
            break;
        case DIAMONDS:
            str += "D";
            break;
        case CLUBS:
            str += "C";
            break;
        }
        return str;
    }

    public final int num;
    public final Suit suit;
}
