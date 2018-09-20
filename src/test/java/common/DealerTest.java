package common;

import junit.framework.TestCase;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import common.Card.Rank;
import common.Card.Suit;

public class DealerTest {
	
	@Test
	public void test26_dealerHitsWithSixteenAndLower(){
		// Arrange
		Dealer dealer = new Dealer();
		
		// Act
		dealer.addCard(new Card(Rank.EIGHT, Suit.C));
		dealer.addCard(new Card(Rank.EIGHT, Suit.H));

		// Assert		
		assertTrue(dealer.shouldHit());
	}
	
	@Test
	public void test27_dealerHitsWithSoftSeventeen() {
		// Arrange
		Dealer dealer = new Dealer();
		
		// Act
		dealer.addCard(new Card(Rank.ACE, Suit.C));
		dealer.addCard(new Card(Rank.SIX, Suit.H));

		// Assert		
		assertTrue(dealer.shouldHit());
	}
	
	@Test
	public void dealerHitsRepeatedly() {
		
	}
	
	@Test
	public void dealerInitialBlackjackDetected() {
		
	}
	
	@Test
	public void dealerHasBlackjackWins() {
		
	}
	
	@Test
	public void displayScoreOfDealerWinningHand() {
		
	}
	
}
