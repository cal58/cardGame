package games;

import java.util.Scanner;

import cards.Card;
import cards.Deck;

/**
 * Higher or Lower command game. Works by command line input.
 * @author camilla
 *
 */
public class HigherOrLower {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Higher or Lower.");
		// Setup deck and shuffle.
		Deck pack = new Deck();
		pack.shuffleCards();
		Scanner input = new Scanner(System.in);
		
		int score = 0;
		boolean game = true;
		
		for (int ii=0; ii<52; ii++) {
			Card card = pack.getCard(ii);
			Card nextCard = pack.getCard(ii+1);
			
			card.printInfo();
			System.out.println("Will the next card be higher (h) or lower (l)?");
			while (true) {

				int cardNum = card.getNumber().getInt();
				int nextNum = nextCard.getNumber().getInt();
				
				String readIn = input.nextLine();
				//input.close();
				
				// If you guessed wrong.
				if (((readIn.equalsIgnoreCase("h")) && (nextNum < cardNum)) || ((readIn.equalsIgnoreCase("l")) && (nextNum > cardNum))) {
					//System.out.println("Wrong :(");
					game = false;
					break;
				// If you guessed right.
				} else if (((readIn.equalsIgnoreCase("h")) && (nextNum > cardNum)) || ((readIn.equalsIgnoreCase("l")) && (nextNum < cardNum))) {
					score++;
					System.out.println("Correct!");
					break;
				// If cards were equal.
				} else if (nextNum == cardNum) {
					score++;
					System.out.println("Cards were equal!");
					break;
				} else {
					System.out.println("Invalid response. Please enter h or l.");
				}
			}
			if (game == false) {
				break;
			}
		}
		// Case for winning and finishing needed.
		System.out.println("Game over. Your score is "+score+".");
		input.close();
	}

}
