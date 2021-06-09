import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Card implements Comparable {
	
	public final static String[] theRanks = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Jack", "Queen", "King", "Ace" };

	public final static String[] theSuits = { "Clubs", "Diamonds", "Hearts", "Spades" };

	public static final String [] imgRanks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
				"jack", "queen", "king", "ace"};

	public static final String [] imgSuits = {"clubs", "diamonds", "hearts", "spades"};
	
	private int myId;

	public Card(int id) // val is between 0 and 51 inclusive
	{
		myId = id;
	}

	public int getId() {
		return myId;
	}

	public int getRankNum() {
		return myId / 4;
	}

	public int getSuitNum() {
		return myId % 4;
	}

	public String getRank() {
		return theRanks[getRankNum()];
	}

	public String getSuit() {
		return theSuits[getSuitNum()];
	}

	public String toString() {
		String s = getRank() + " of  " + getSuit();
		return s;
	}
	
	public String imageString ()
	{
		  String s = "img/";
		  s += imgRanks[getRankNum()];
		  s += "_of_";
		  s += imgSuits[getSuitNum()];
		  s += ".png";

		  return s; 
	}

	public int compareTo(Object obj) // we must define this to implement
										// Comparable
	{
		Card c = (Card) obj;
		return myId - c.getId();

	}
	
	/*
	public void draw (Graphics g, int x, int y)
	{
				Image image = new ImageIcon(this.imageString()).getImage(); 
	
				g.drawImage(image, 100, 100,
				image.getWidth(this) / 5, image.getHeight(this) / 5,
				g);
		
	}
	*/
	

}
