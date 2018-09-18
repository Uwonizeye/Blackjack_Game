package common;

import org.junit.Test;
import junit.framework.TestCase;


public class DeckTest extends TestCase{
	
	private Deck deck;
	private Card topCard;
	
	@Test
	public void deckHasFiftyTwoCards() {
		assertEquals(52, deck.cardsLeft() == 52);
	}
	
	@Test
	public void deckIsShuffled() {
	}
}

