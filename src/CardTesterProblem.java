import java.util.ArrayList;
import java.util.Random;

/**
 * CardTester.java

 *
 * @author 
 * @version 1.00 2007/10/2
 */

 
public class CardTesterProblem {
	
    public static void main(String[] args) {

    	Random gen = new Random();
    	ArrayList<Card> theCards = new ArrayList<Card>();

    	for (int j = 0; j < 52; j++)
    		theCards.add(new Card(j));

    	ArrayList <Card> shuffled = new ArrayList <Card>();

    	for (int k = 0; k < theCards.size(); k++)
    	{
    	  Card temp = theCards.remove(k);
    	  int pos = gen.nextInt(shuffled.size() + 1);
    	  shuffled.add(pos, temp);
    	}

    	System.out.println ("shuffled: " + shuffled);
    	System.out.println ("theCards: " + theCards);
    	
    	System.out.println ("Length of shuffled: " + shuffled.size());
    	System.out.println ("Length of theCards: " + theCards.size());
    	
   

    	
    
    
    }
}
