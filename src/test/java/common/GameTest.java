package common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import common.Card.Rank;
import common.Card.Suit;
import common.Game.Winner;
import common.GameMode.Move;

import static org.mockito.Mockito.*;

// We are using Mockito along with JUnit, so that we have control over the cards that are dealt
// Since they are otherwise drawn randomly
// @RUnWith makes sure Junit will run with the specified class and not the built in JUnit

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@Mock
	public GameMode gameMode;

	
	@Test
	public void dealerWinsWithBlackjack() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.C), new Card(Rank.NINE, Suit.C),
				new Card(Rank.ACE, Suit.H), new Card(Rank.JACK, Suit.H)
				);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.DEALER, winner);
	}

	
	@Test
	public void dealerWinsWithBlackjackWhenPlayerAlsoHasBlackjack() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.H), new Card(Rank.JACK, Suit.H),
				new Card(Rank.ACE, Suit.C), new Card(Rank.JACK, Suit.C)
				);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.DEALER, winner);
	}

	
	@Test
	public void playerWinsWithBlackjack() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.H), new Card(Rank.JACK, Suit.H),
				new Card(Rank.ACE, Suit.C), new Card(Rank.NINE, Suit.C)
				);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.PLAYER, winner);
	}
	
	
	
	@Test
	public void playerBusts() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.H), new Card(Rank.NINE, Suit.H),
				new Card(Rank.ACE, Suit.C), new Card(Rank.NINE, Suit.C),
				new Card(Rank.NINE, Suit.S)
				);
		when(gameMode.getPlayerMove()).thenReturn(Move.HIT);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.DEALER, winner);
	}

	
	
	@Test
	public void dealerBusts() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.H), new Card(Rank.NINE, Suit.H),
				new Card(Rank.ACE, Suit.C), new Card(Rank.FIVE, Suit.C),
				new Card(Rank.NINE, Suit.S)
				);
		when(gameMode.getPlayerMove()).thenReturn(Move.STAND);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.PLAYER, winner);
	}


	
	@Test
	public void dealerHasSameValueAsPlayer() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.H), new Card(Rank.NINE, Suit.H),
				new Card(Rank.ACE, Suit.C), new Card(Rank.NINE, Suit.C)
				);
		when(gameMode.getPlayerMove()).thenReturn(Move.STAND);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.DEALER, winner);
	}


	@Test
	public void dealerGreaterValueThanPlayer() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.H), new Card(Rank.EIGHT, Suit.H),
				new Card(Rank.ACE, Suit.C), new Card(Rank.NINE, Suit.C)
				);
		when(gameMode.getPlayerMove()).thenReturn(Move.STAND);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.DEALER, winner);
	}

	
	@Test
	public void playerGreaterValueThanDealer() {
		// Arrange
		when(gameMode.getCard()).thenReturn(
				new Card(Rank.ACE, Suit.C), new Card(Rank.NINE, Suit.C),
				new Card(Rank.ACE, Suit.H), new Card(Rank.EIGHT, Suit.H)
				);
		when(gameMode.getPlayerMove()).thenReturn(Move.STAND);
		Game game = new Game(gameMode);

		// Act
		Winner winner = game.play();

		// Assert
		assertEquals(Winner.PLAYER, winner);
	}

}
