import java.util.ArrayList;
import java.util.Random;

/**
 * DeckTester.java

 *
 * @author Casey McCullough
 * @version 1.00 2007/10/2
 * Tests methods of Card, Deck, and FiveCardHand
 */

 
public class DeckTester {
 
    public static void main(String[] args) {
    
     Deck theDeck = new Deck();
     System.out.println (theDeck);

     theDeck.shuffle();
    // System.out.println ("\nShuffled: ");  
    // System.out.println (theDeck);
     
    
    }
}
