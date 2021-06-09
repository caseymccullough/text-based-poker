import java.util.ArrayList;
import java.util.Random;

/**
 * FiveCardHandTester.java

 *
 * @author Casey McCullough
 * @version 1.00 2007/10/2
 * Tests methods of Card, Deck, and FiveCardHand
 */

 
public class FiveCardHandTester {
 
    public static void main(String[] args) {
    
     Deck theDeck = new Deck();
     System.out.println (theDeck);

     theDeck.shuffle();
     System.out.println ("\nShuffled: ");  
     System.out.println (theDeck);
     
     FiveCardHand fiveCards = new FiveCardHand (theDeck.deal(5));
     
     System.out.println(fiveCards);
    
     System.out.println ("\nRemaining Deck, sorted: \n" + theDeck);      
     theDeck.sort(); // NEW
     System.out.println(theDeck);
      
     System.out.println(fiveCards);
 
    
    }
}
