import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solitaire {
    public static void main(String[] args) {
        final Foundations foundations = new Foundations();
        final StockWaste stockWaste = new StockWaste();
        final Tableau tableau = new Tableau();

        List<Card> bag = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (Card.Suit suit : Card.Suit.values()) {
                bag.add(new Card(i, suit));
            }
        }
        Collections.shuffle(bag);
        Iterator<Card> bagIterator = bag.iterator();

        foundations.init();
        tableau.init(bagIterator);
        stockWaste.init(bagIterator, 3);

        Scanner scanner = new Scanner(System.in);

        String command;
        while (true) {
            System.out.println("========================");
            foundations.print();
            stockWaste.print();
            tableau.print();

            System.out.println();
            System.out.print("> ");
            command = scanner.next();
            switch (command) {
                case "wt": {
                    int destIndex = scanner.nextInt();
                    if (tableau.add(stockWaste.get(), destIndex)) {
                        stockWaste.remove();
                    } else {
                        System.out.println("Illegal!");
                    }
                    break;
                }
                case "wf": {
                    int destIndex = scanner.nextInt();
                    if (foundations.add(stockWaste.get(), destIndex)) {
                        stockWaste.remove();
                    } else {
                        System.out.println("Illegal!");
                    }
                    break;
                }
                case "tf": {
                    int srcIndex = scanner.nextInt();
                    int destIndex = scanner.nextInt();
                    if (foundations.add(tableau.get(srcIndex), destIndex)) {
                        tableau.remove(srcIndex);
                    } else {
                        System.out.println("Illegal!");
                    }
                    break;
                }
                case "ft": {
                    int srcIndex = scanner.nextInt();
                    int destIndex = scanner.nextInt();
                    if (tableau.add(foundations.get(srcIndex), destIndex)) {
                        foundations.remove(srcIndex);
                    } else {
                        System.out.println("Illegal!");
                    }
                    break;
                }
                case "tt": {
                    int srcIndex = scanner.nextInt();
                    int headIndex = scanner.nextInt();
                    int destIndex = scanner.nextInt();
                    if (!tableau.move(srcIndex, headIndex, destIndex)) {
                        System.out.println("Illegal!");
                    }
                    break;
                }
                case "r":
                    stockWaste.rotate();
                    break;
                case "q":
                    return;
            }
            scanner.nextLine();
        }
    }
}
