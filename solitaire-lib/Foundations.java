import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class Foundations {
    public Foundations() {
        piles = List.of(new ArrayDeque<>(),
                new ArrayDeque<>(),
                new ArrayDeque<>(),
                new ArrayDeque<>());
    }

    public void init() {
        for (Deque<Card> pile : piles) {
            pile.clear();
        }
    }

    public boolean addCard(Card card, int destIndex) {
        Deque<Card> pile = piles.get(destIndex);
        if (!pile.isEmpty()) {
            Card top = pile.peek();
            if (card.num - top.num != 1 || top.suit != card.suit) {
                return false;
            }
        } else if (card.num != 1) {
            return false;
        }
        pile.push(card);
        return true;
    }

    public Card takeCard(int srcIndex) {
        return piles.get(srcIndex).pop();
    }

    public boolean checkWin() {
        for (Deque<Card> pile : piles) {
            if (pile.isEmpty() || pile.peek().num != 13) {
                return false;
            }
        }
        return true;
    }

    private final List<Deque<Card>> piles;
}
