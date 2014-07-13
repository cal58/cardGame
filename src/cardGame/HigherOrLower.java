package cardGame;

import java.util.Scanner;

public class HigherOrLower {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Higher or Lower.");
		// Setup deck and shuffle.
		Deck pack = new Deck();
		pack.shuffleCards();;
		
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
				
				Scanner input = new Scanner(System.in);
				String readIn = input.nextLine();
				//input.close();
				
				// If you guessed wrong.
				if (((readIn.equalsIgnoreCase("h")) && (nextNum < cardNum)) || ((readIn.equalsIgnoreCase("l")) && (nextNum > cardNum))) {
					System.out.println("Wrong :(");
					game = false;
					break;
				// If you guessed right, or cards were equal.
				} else if (((readIn.equalsIgnoreCase("h")) && (nextNum > cardNum)) || ((readIn.equalsIgnoreCase("l")) && (nextNum < cardNum)) || (nextNum == cardNum)) {
					score++;
					System.out.println("Correct!");
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
	}

}
