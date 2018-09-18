

public class Deck {
	
	private int currentDeckSize;
	private int cardIndex;
	
	public final int DECK_SIZE = 52;
	private Card[] cards;

	
	public Deck(){
		cardIndex = 0;
		currentDeckSize = DECK_SIZE;
		cards = new Card[DECK_SIZE];
		getNewDeck();
		shuffle();
	}
	
	// Checks the current deck size
	public int cardsLeft() {
		
		return currentDeckSize;
	}
	
	// get new deck of cards
	public void getNewDeck() {
		shuffle();
		currentDeckSize = DECK_SIZE;
		
	}
	
	// Shuffles the deck of cards 
	public void shuffle() {
	
	}
	
}
