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

    public boolean add(Card card, int destIndex) {
        Deque<Card> destPile = piles.get(destIndex);
        if (!destPile.isEmpty()) {
            Card top = destPile.peek();
            if (card.num - top.num != 1 || top.suit != card.suit) {
                return false;
            }
        } else if (card.num != 1) {
            return false;
        }
        destPile.push(card);
        return true;
    }

    public Card get(int srcIndex) {
        return piles.get(srcIndex).peek();
    }

    public void remove(int srcIndex) {
        piles.get(srcIndex).pop();
    }

    public boolean checkWin() {
        for (Deque<Card> pile : piles) {
            if (pile.isEmpty() || pile.peek().num != 13) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (Deque<Card> pile : piles) {
            System.out.print(pile.peek() + " ");
        }
        System.out.println();
    }

    private final List<Deque<Card>> piles;
}
