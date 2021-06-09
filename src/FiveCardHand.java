import java.util.ArrayList;

public class FiveCardHand {
    
    private ArrayList <Card> myCards;
   
    public FiveCardHand (ArrayList <Card> theCards)
    {
          myCards = theCards;
         
    } 
    
    public ArrayList<Card> getCards()
    {
    		return myCards;
    }
     
    public String toString ()
    {
                String theCards = "FIVE CARDS:\n";
                for (int i = 0; i < myCards.size(); i++)
                                theCards += "Card # " + (i + 1) + ": " + myCards.get(i) + "\n";
                                
                return theCards;
   
    } 
        
        public ArrayList <Card> exchange (boolean [] replace, Deck deckCards)
     {
          ArrayList <Card> discards = new ArrayList <Card> ();
          Card newCard;
          Card oldCard;
          
          for (int i = 0; i < 5; i++)
          if (replace[i] == true)
          {
             newCard = deckCards.deal(1).get(0);
             oldCard = myCards.set(i, newCard);
             discards.add (oldCard);
            
          }

          // for each card in 5-card hand, if replace is true
          // replace corresponding position in myCards with 
          // new Card from deckCards
          
          // outputs result of each swap
             
             return discards;
          
     }
        /**
         * counts the quantity of each rank within myCards
         * @return a count of all 13 ranks from 2 to Ace found within myCards
         */
        private int[] rankCount()
        {
        	
        		int[] cardCounts = new int[13];
        		for (int k = 0; k < myCards.size(); k++)
        		{
        			Card c = myCards.get(k);
        			cardCounts[c.getRankNum()]++;
        		}
        		return cardCounts; 
        }
        
        public String evaluate()
        {
        		return "some hand";
        }
        

}
        

        
