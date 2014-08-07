package games;

import java.util.ArrayList;

import players.CribbagePlayer;
import players.RandomCribbagePlayer;
import cards.Card;
import cards.Deck;
import cards.Hand;
import cards.Value;

/**
 * 
 * @author camilla
 *
 */
public class Cribbage {
	/* How to play:
	 * Assume player two is the dealer (so p1 starts everything).
	 ** SETUP
	 ** 		Shuffle deck (assumed completely fair, so no cutting required).
	 ** 		Deal 6 cards to 2 players.
	 ** 		Players each give 2 cards to a 3rd hand (so we have 3 hands of 4 cards).
	 **			Turn over top card of the rest of the deck.
	 * PART A
	 *		Players place a card down alternately (starting with player one).
	 *		Potential for scoring (runs [in any order], 15, pairs, 4 of a suit).
	 *		A point if running total is 31.
	 *		A point if you put a card down and other player can't play and keep total <31.
	 * PART B
	 *		Score hands: runs, 15s, pairs, 4 of a suit.
	 *		Player without box goes first, then player with box, then box.
	 *		First player to get to 61 points wins.		
	 */
	private static Deck deck = new Deck();
	
	public static void main(String[] args) {

		// SETUP
		CribbagePlayer playerOne = new RandomCribbagePlayer();
		CribbagePlayer playerTwo = new RandomCribbagePlayer();
		
		ArrayList<Hand> hands = deal();
		hands = giveCardsToBox(hands, playerOne, playerTwo);
		
		Card topCard = deck.removeTopCard();
		topCard.printInfo();
		
		if (topCard.getNumber().equals(Value.Jack)) {
			playerOne.increaseScore(2);
		}
		
		// PART A
		int packScore = 0;
		int runNum = 0;
		
		CribbagePlayer player = null;
		Hand currentHand = null;
		Hand currentCards = new Hand();

		while (packScore < 31) {
			//Sets up which player / hand we're using.
			if (runNum%2 == 0) {
				player = playerOne;
				currentHand = hands.get(1);
			} else {
				player = playerTwo;
				currentHand = hands.get(2);
			}
			runNum++;
			
			currentCards.addCard(player.placeCard(currentHand));
			
			int points = getPartAScore(currentHand);
			
			player.increaseScore(points);
		}
		
		
	}
	
	private static int getPartAScore(Hand currentHand) {
		return 0;
	}

	private static ArrayList<Hand> deal() {
		deck.shuffleCards();
		
		ArrayList<Hand> hands = deck.dealCards(6,2);
		
		System.out.println("Player One was delt:");
		hands.get(0).printAllCards();
		System.out.println("");
		System.out.println("Player Two was delt:");
		hands.get(1).printAllCards();
		System.out.println("");
		
		return hands;
	}
	
	private static ArrayList<Hand> giveCardsToBox(ArrayList<Hand> hands, CribbagePlayer playerOne, CribbagePlayer playerTwo) {
		ArrayList<Hand> newHands = new ArrayList<Hand>();
		Hand playerOneNewHand = hands.get(0);
		Hand playerTwoNewHand = hands.get(1);
		
		// Gets cards from players to put in box.
		ArrayList<Card> boxCardsOne = playerOne.cardsToBox(playerOneNewHand);
		ArrayList<Card> boxCardsTwo = playerTwo.cardsToBox(playerTwoNewHand);
		
		// Create box.
		Hand box = new Hand(boxCardsOne);
		box.addCards(boxCardsTwo);
		
		// Remove box cards from hands.
		playerOneNewHand.removeCards(boxCardsOne);
		playerTwoNewHand.removeCards(boxCardsTwo);
		
		// Add new hands to returned list.
		newHands.add(box);
		newHands.add(playerOneNewHand);
		newHands.add(playerTwoNewHand);
		
		return newHands;
	}
}
