import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class StockWaste {
    public StockWaste() {
        stock = new ArrayDeque<>();
        waste = new ArrayDeque<>();
    }

    public void init(Iterator<Card> src, int rotAmount) {
        this.rotAmount = rotAmount;
        stock.clear();
        waste.clear();
        while (src.hasNext()) {
            stock.add(src.next());
        }
    }

    public void rotate() {
        if (!stock.isEmpty()) {
            for (int i = 0; i < rotAmount && !stock.isEmpty(); i++) {
                waste.push(stock.removeLast());
            }
        } else {
            Deque<Card> temp = stock;
            stock = waste;
            waste = temp;
        }
    }

    public Card get() {
        return waste.peek();
    }

    public void remove() {
        waste.pop();
    }

    public void print() {
        Iterator<Card> wasteIterator = waste.iterator();
        for (int i = 0; i < 3 && wasteIterator.hasNext(); i++) {
            System.out.print(wasteIterator.next() + " ");
        }
        System.out.println();
    }

    private Deque<Card> stock;
    private Deque<Card> waste;
    private int rotAmount;
}
