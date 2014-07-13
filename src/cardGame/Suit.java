package cardGame;

public enum Suit {
	HEARTS(0), DIAMONDS(1), CLUBS(2), SPADES(3);
	
	private int value;
		
	private Suit(int value) {
		this.value = value;
	}
}
