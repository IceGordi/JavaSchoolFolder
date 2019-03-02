/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
		String[] suits = {"Heart","Spades","Diamond","Clubs"};
		int[] values = {1,2,3,4,5,6,7,8,9,10,11,12};
		Deck magicDeck = new Deck(ranks,suits,values);
		System.out.println(magicDeck.isEmpty());
		System.out.println(magicDeck.size());
		System.out.println(magicDeck.toString());
		magicDeck.shuffle();
		System.out.println(magicDeck.toString());
	}
}
