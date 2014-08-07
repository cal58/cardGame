package games;

import java.util.Scanner;

import cards.Card;
import cards.Deck;

/**
 * Plays n games to try and "win" / get the best score for a higher or lower guessing game.
 * Counts cards to figure out the probability of the next card being higher or lower.
 * @author camilla
 * 
 * TODO: What happens if we win!
 *
 */
public class HigherOrLowerAuto {
	
	public static void main(String[] args) {
		int bestScore = 0;
		double runningAverage = 0;
		int numRuns = 10000000;
		String dumbOrClever = "clever";
		boolean stopGame = false;
		
		for (int jj=0; jj<numRuns; jj++) {

			// Setup deck and shuffle.
			Deck pack = new Deck();
			pack.shuffleCards();
	
			// Setup input stream and score.
			Scanner input = new Scanner(System.in);
			int score = 0;
			
			if (stopGame) {
				break;
			}
			
			while (pack.size() > 2){
				// Pop and peek.
				Card card = pack.removeTopCard();
				Card nextCard = pack.getCard(1);
				
				String guess = "";
				if (dumbOrClever.equalsIgnoreCase("dumb")) {
					guess = dumbAI(card);
				} else if (dumbOrClever.equalsIgnoreCase("clever")) {
					guess = cleverAI(card, pack);
				} else {
					System.out.println("Error. AI incorrectly specified. Only use 'dumb' or 'clever'. You used '"+dumbOrClever+"'.");
					stopGame = true;
				}
				
				if (stopGame) {
					break;
				}
				
				boolean game = checkCards(card, nextCard, guess, false);
	
				if (game == false) {
					//System.out.print("Wrong! The next card was the ");
					//nextCard.printInfo();
					break;
				} else {
					score++;
				}
			}
			//System.out.println("Your score was "+score+".");
			if (score > bestScore) {
				bestScore = score;
			}
			
			// Finds the running average.
			runningAverage = (runningAverage*(jj) + score)/(jj+1);
			//System.out.println(jj+"\t"+score+"\t"+runningAverage);
			
			input.close();
		}
		System.out.println("Best score:\t"+bestScore);
	}
	
	private static boolean checkCards(Card currentCard, Card nextCard, String guess, boolean print) {
		int cardNum = currentCard.getNumber().getInt();
		int nextNum = nextCard.getNumber().getInt();
		
		// If you guessed wrong.
		if (((guess.equalsIgnoreCase("h")) && (nextNum < cardNum)) || ((guess.equalsIgnoreCase("l")) && (nextNum > cardNum))) {
			return false;
		
		// If you guessed right.
		} else if (((guess.equalsIgnoreCase("h")) && (nextNum > cardNum)) || ((guess.equalsIgnoreCase("l")) && (nextNum < cardNum))) {
			cPrint("Correct!", print);
			return true;
		
		// If cards were equal.
		} else {
			cPrint("Cards were equal!", print);
			return true;
		}
	}
	
	private static void cPrint(String toPrint, boolean print) {
		if (print) {
			System.out.println(toPrint);
		}
	}
	
	private static String dumbAI(Card card) {
		String guess = "";
		int currentNum = card.getNumber().getInt();
		
		if (currentNum <= 6) {
			guess = "h";
		} else {
			guess = "l";
		}
		return guess;
	}
	
	private static String cleverAI(Card card, Deck cardsLeft) {
		String guess = "";
		int currentNum = card.getNumber().getInt();
		
		boolean guessLower = cardsLeft.isLowerLikely(currentNum);
		
		if (guessLower) {
			guess = "l";
		} else {
			guess = "h";
		}
		
		return guess;
	}
	
}
