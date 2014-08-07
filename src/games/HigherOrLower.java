package games;

import java.util.Scanner;

import cards.Card;
import cards.Deck;

/**
 * Higher or Lower command game. Works by command line input.
 * @author camilla
 * 
 * TODO: What happens if we win!
 */
public class HigherOrLower {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Higher or Lower.");
		
		// Setup deck and shuffle.
		Deck pack = new Deck();
		pack.shuffleCards();

		// Setup input stream and score.
		Scanner input = new Scanner(System.in);
		int score = 0;
		
		for (int ii=0; ii<52; ii++) {
			Card card = pack.getCard(ii);
			Card nextCard = pack.getCard(ii+1);
			
			card.printInfo();
			System.out.println("Will the next card be higher (h) or lower (l)?");
			
			String guess = input.nextLine();
				
			while (!(guess.equalsIgnoreCase("h") || guess.equalsIgnoreCase("l"))) {
				System.out.println("Invalid response. Please enter h or l.");
				guess = input.nextLine();
			}
				
			boolean game = checkCards(card, nextCard, guess, true);

			if (game == false) {
				System.out.print("Wrong! The next card was the ");
				nextCard.printInfo();
				break;
			} else {
				score++;
			}
		}
		System.out.println("Your score was "+score+".");
		input.close();
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

}
