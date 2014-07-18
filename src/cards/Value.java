package cards;

/**
 * Enum for a card value: ace through king. 
 * @author camilla
 *
 */
public enum Value {
	Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
	
	private int faceValue;
		
	private Value(int value) {
		this.faceValue = value;
	}
	
	public int getInt() {
		return faceValue;
	}
}
