package common;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import common.Card.Rank;
import common.Card.Suit;

public class DealerTest {
	
	@Test
	public void dealerHitsWithSixteenAndLower(){
		// Arrange
		Dealer dealer = new Dealer();
		
		// Act
		dealer.addCard(new Card(Rank.EIGHT, Suit.C));
		dealer.addCard(new Card(Rank.EIGHT, Suit.H));

		// Assert		
		assertTrue(dealer.shouldHit());
	}
	
	@Test
	public void dealerHitsWithSoftSeventeen() {
		// Arrange
		Dealer dealer = new Dealer();
		
		// Act
		dealer.addCard(new Card(Rank.ACE, Suit.C));
		dealer.addCard(new Card(Rank.SIX, Suit.H));

		// Assert		
		assertTrue(dealer.shouldHit());
	}
	

	
}
