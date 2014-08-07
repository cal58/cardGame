package players;

import java.util.ArrayList;

import cards.Card;
import cards.Hand;

public class RandomCribbagePlayer implements CribbagePlayer {

	private int score = 0;
	
	@Override
	public ArrayList<Card> cardsToBox(Hand hand) {
		hand.shuffle();
		ArrayList<Card> cardsToBox = new ArrayList<Card>();
		
		// Print cards out.
		System.out.println("Cards going into the box are:");
		
		for (int ii=0; ii<2; ii++) {
			Card boxCard = hand.removeTopCard();
			cardsToBox.add(boxCard);
			boxCard.printInfo();
		}
		System.out.println();
		return cardsToBox;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void increaseScore(int n) {
		for (int ii=0; ii<n; ii++) {
			score++;
		}
	}

	@Override
	public Card placeCard(Hand hand) {
		hand.shuffle();
		return hand.getCard(0);
	}

}
