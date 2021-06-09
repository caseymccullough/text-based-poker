import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

public class FiveCardHandTest {

	@Test
	public void testFourOfKind() {
		// arrange
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(0));
		cards.add(new Card(1));
		cards.add(new Card(2));
		cards.add(new Card(3));
		cards.add(new Card(4));
		// act
		FiveCardHand hand = new FiveCardHand(cards);
		
		String result = hand.evaluate();
		System.out.println (result);
		// assert
		assertEquals ("some hand", result);
	}
	
	

}
