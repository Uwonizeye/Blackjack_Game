package common;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import common.Card.Rank;
import common.Card.Suit;

public class HandTest {


	
	@Test
	public void aceCanCountAsOne() {
		// Arrange
		Hand hand = new Hand();

		// Act
		hand.addCard(new Card(Rank.ACE, Suit.C));
		hand.addCard(new Card(Rank.JACK, Suit.H));
		hand.addCard(new Card(Rank.JACK, Suit.H));
		
		//Assert
		assertEquals(21, hand.getValue());
	}

	@Test
	public void aceCanCountAsEleven() {
		// Arrange
		Hand hand = new Hand();

		// Act
		hand.addCard(new Card(Rank.ACE, Suit.C));
		hand.addCard(new Card(Rank.JACK, Suit.H));
		
		//Assert
		assertEquals(21, hand.getValue());
	}



	@Test
	public void aceCanCountAsOneAndEleven() {
		// Arrange
		Hand hand = new Hand();

		// Act
		hand.addCard(new Card(Rank.ACE, Suit.C));
		hand.addCard(new Card(Rank.ACE, Suit.H));
		
		//Assert
		assertEquals(12, hand.getValue());
	}

	@Test
	public void aceCanBeCountedAsOneThenAsEleven() {
		// Arrange
		Hand hand = new Hand();
		hand.addCard(new Card(Rank.FIVE, Suit.C));
		hand.addCard(new Card(Rank.ACE, Suit.H));
		assertEquals(16, hand.getValue());

		// Act
		hand.addCard(new Card(Rank.SEVEN, Suit.C));
		
		// Assert
		assertEquals(13, hand.getValue());
	}
	


	@Test
	public void aceCanCountAsOneAndOne() {
		// Arrange
		Hand hand = new Hand();

		// Act
		hand.addCard(new Card(Rank.ACE, Suit.C));
		hand.addCard(new Card(Rank.ACE, Suit.H));
		hand.addCard(new Card(Rank.JACK, Suit.H));
		
		//Assert
		assertEquals(12, hand.getValue());
	}
	
	@Test
	public void JQKCountsAsTen() {
		for (Rank rank: Arrays.asList(Rank.JACK, Rank.QUEEN, Rank.KING)) {
			// Arrange
			Hand hand = new Hand();
			
			// Act
			hand.addCard(new Card(Rank.ACE, Suit.C));
			hand.addCard(new Card(rank, Suit.C));

			// Assert
			assertEquals(21, hand.getValue());
		}
	}
}
