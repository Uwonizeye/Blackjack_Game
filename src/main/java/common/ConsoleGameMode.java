package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class ConsoleGameMode implements GameMode {

	private Deck deck;
	private BufferedReader reader;

	public ConsoleGameMode(BufferedReader reader) {
		this.reader = reader;
		deck = new Deck(new Random());
	}

	@Override
	public Card getCard() {
		return deck.draw();
	}

	@Override
	public Move getPlayerMove() {
		try {
			while (true) {
				System.out.println("What do you want to do? Hit (H) or Stand (S)?");
				String response = reader.readLine();
				if ("s".equalsIgnoreCase(response)) {
					return Move.STAND;
				} else if ("h".equalsIgnoreCase(response)) {
					return Move.HIT;
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
