import java.util.ArrayList;
import java.util.Random;

/**
 * CardTester.java

 *
 * @author 
 * @version 1.00 2007/10/2
 */

 
public class CardTester {
	
    public static void main(String[] args) {
    
	     for (int j = 0; j < 52; j++)
	     {
	    	 	Card c = new Card(j);
	     // any value between 0 and 51 produces a legitimate unique card
	     
	    	 	System.out.println(j + " " + c + " " + c.imageString());
	     }
    
    }
}
