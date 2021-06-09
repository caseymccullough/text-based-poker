import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * FiveCardGrading.java
 *
 * @author Casey McCullough
 * @version 1.00 2007/10/2
 * Tests the evaluate method of FiveCardHand
 */

 
public class FiveCardHandGrading {
 
	final static String TEST_FILE  = "TesterHands.txt";
	
    public static void main(String[] args) {
    
    	File file = new File (TEST_FILE);
    	try {
			Scanner inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     
     ArrayList a1 = new ArrayList<Card>();
     a1.add(new Card(0));
     a1.add(new Card(1));
     a1.add(new Card(2));
     a1.add(new Card(3));
     a1.add(new Card(4));
     
     FiveCardHand h1 = new FiveCardHand(a1);
     
     System.out.println(h1);
     System.out.println(h1.evaluate()); // should result in "Four of a Kind."
     
     a1.clear();
     a1.add(new Card(1));
     a1.add(new Card(5));
     a1.add(new Card(9));
     a1.add(new Card(13));
     a1.add(new Card(17));
     
     FiveCardHand h2 = new FiveCardHand(a1);
     
     System.out.println(h1);
     System.out.println(h1.evaluate()); // should result in "Flush"
 
    
    }
}
