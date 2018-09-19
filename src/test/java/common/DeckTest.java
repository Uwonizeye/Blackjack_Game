package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class DeckTest {
	
	private Random random = new Random();
	
	@Test
	public void deckHasFiftyTwoCards() {
		Deck deck = new Deck(random);
		assertEquals(52, deck.cardsLeft());
	}
	
	@Test
	public void deckIsShuffled() {
		
		Deck d1 = new Deck(new Random(random.nextInt()));
		Deck d2 = new Deck(new Random(random.nextInt()));

		assertNotEquals(d1, d2);
	}
}

