package cards;

public enum Suit {
	Hearts(0), Diamonds(1), Clubs(2), Spades(3);
	
	private int value;
		
	private Suit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
