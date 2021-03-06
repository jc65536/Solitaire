import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tableau {
    public Tableau() {
        piles = List.of(new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());
        firstFaceUp = new int[7];
    }

    public void init(Iterator<Card> src) {
        for (int i = 0; i < 7; i++) {
            List<Card> pile = piles.get(i);
            pile.clear();
            for (int j = 0; j < i + 1; j++) {
                pile.add(src.next());
            }
            firstFaceUp[i] = i;
        }
    }

    public boolean add(Card card, int destIndex) {
        List<Card> destPile = piles.get(destIndex);
        return canAdd(card, destPile) && destPile.add(card);
    }

    public Card get(int srcIndex) {
        List<Card> srcPile = piles.get(srcIndex);
        return srcPile.get(srcPile.size() - 1);
    }

    public void remove(int srcIndex) {
        List<Card> srcPile = piles.get(srcIndex);
        int cardIndex = srcPile.size() - 1;
        srcPile.remove(cardIndex);
        if (cardIndex == firstFaceUp[srcIndex]) {
            firstFaceUp[srcIndex]--;
        }
    }

    public boolean move(int srcIndex, int headIndex, int destIndex) {
        if (destIndex == srcIndex || headIndex < firstFaceUp[srcIndex]) {
            return false;
        }
        List<Card> srcPile = piles.get(srcIndex);
        List<Card> chain = srcPile.subList(headIndex, srcPile.size());
        List<Card> destPile = piles.get(destIndex);
        if (canAdd(chain.get(0), destPile)) {
            destPile.addAll(chain);
            chain.clear();
            if (headIndex == firstFaceUp[srcIndex]) {
                firstFaceUp[srcIndex]--;
            }
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < 7; i++) {
            System.out.print(i + ": ");
            int j = 0;
            for (; j < firstFaceUp[i]; j++) {
                System.out.print("?? ");
            }
            List<Card> pile = piles.get(i);
            for (; j < pile.size(); j++) {
                System.out.print(pile.get(j) + " ");
            }
            System.out.println();
        }
    }

    private boolean canAdd(Card card, List<Card> destPile) {
        if (!destPile.isEmpty()) {
            Card tail = destPile.get(destPile.size() - 1);
            if (tail.num - card.num == 1 && (tail.suit == Card.Suit.SPADES || tail.suit == Card.Suit.CLUBS)
                    ^ (card.suit == Card.Suit.SPADES || card.suit == Card.Suit.CLUBS)) {
                return true;
            }
        } else if (card.num == 13) {
            return true;
        }
        return false;
    }

    private final List<List<Card>> piles;
    private final int[] firstFaceUp;
}
