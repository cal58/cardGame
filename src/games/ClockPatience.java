package games;

import java.util.ArrayList;

import cards.Card;
import cards.Deck;
import cards.Hand;
import cards.Value;

/**
 * Clock patience single player solitaire game.
 * @author camilla
 *
 *TODO:
 * Write code as a "did it win or not" type thing.
 * Try and represent it with a GUI?
 */
public class ClockPatience {
	
	public static void main(String[] args) {
		int numRuns = 10000;
		int wins = 0;
		int played = 0;
		
		for (int ii=0; ii<numRuns; ii++) {
			boolean result = playClockPatience();
			
			if (result == true) {
				wins++;
				played++;
			} else {
				played++;
			}
		}
		double percent = 100*wins/played;
		System.out.println(percent);
	}
	
	public static boolean playClockPatience() {
		Deck pack = new Deck();
		pack.shuffleCards();
		
		/* INNER HANDS
		 * Deals into 13 hands of 4 cards each. 0 is centre, then others are labelled
		 * as they would be on a clock.
		 */
		ArrayList<Hand> innerHands = pack.dealCards(4,13);
		
		int kingCount = 0;
		Card card = innerHands.get(0).removeTopCard();
		int loops = 1;
		
		while (kingCount < 4) {
			int n = card.getNumber().getInt()%13;
			//card.printInfo();
			
			if (card.getNumber() == Value.King) {
				kingCount++;
			}
			
			Hand nextHand = innerHands.get(n);
			if (nextHand.isEmpty()){
				if (loops < 52) {
					//System.out.println("You lose :(");
					//System.out.println(loops);
					//for (int j=0; j<13; j++) {
						//System.out.println(j+"\t"+innerHands.get(j).size());
					//}
					return false;
				} else {
					//System.out.println("You win!!");
					return true;
				}
			}
			card = nextHand.removeTopCard();
			loops++;
		}
		return false;
	}
	
}
