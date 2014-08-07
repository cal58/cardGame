package players;

import java.util.ArrayList;

import cards.Card;
import cards.Hand;

public interface CribbagePlayer {
	/* This basically lists all the methods a player needs to have.
	 * e.g. 
	 */

	public ArrayList<Card> cardsToBox(Hand hand);
	
	public int getScore();
	public void increaseScore(int n);
	
	public Card placeCard(Hand hand);
}
