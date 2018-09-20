package common;

import java.util.Random;

public class ConsoleGameMode implements GameMode {
	
	private Deck deck;

	public ConsoleGameMode() {
		deck = new Deck(new Random());
	}

	@Override
	public Card getCard() {
		return deck.draw();
	}

	@Override
	public Move getPlayerMove() {
		// TODO Auto-generated method stub
		return null;
	}

}
