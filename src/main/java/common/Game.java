package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import common.GameMode.Move;

public class Game {
	public static void main(String[] args) {
		Game game = new Game(System.in, System.out);
		game.start();
	}

	private BufferedReader in;
	private PrintStream out;

	public Game(InputStream in, PrintStream out) {
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = out;
	}

	public void start() {
		GameMode mode = selectMode();
		Player player = new Player();
		Dealer dealer = new Dealer();

		Card card1 = mode.getCard();
		player.addCard(card1);
		System.out.println("Player was dealt " + card1);

		Card card2 = mode.getCard();
		player.addCard(card2);
		System.out.println("Player was dealt " + card2);

		if (player.hasBlackjack()) {
			System.out.println("Player has blackjack... Will the player win? Let's find out!");
		}

		Card card3 = mode.getCard();
		dealer.addCard(card3);
		System.out.println("Dealer was dealt a card...");

		Card card4 = mode.getCard();
		dealer.addCard(card4);
		System.out.println("Dealer was dealt " + card4);

		if (dealer.hasBlackjack()) {
			System.out.println("Dealer got a blackjack! Did you cross a black cat?");
			System.out.println("Dealer Wins!");
			return;
		} else if (player.hasBlackjack()) {
			System.out.println("Player Wins!");
			return;
		}

		// Player Moves
		whileStatement: while (true) {
			switch (mode.getPlayerMove()) {
			case HIT:
				Card hitCard = mode.getCard();
				player.addCard(hitCard);
				System.out.println("Player was dealt " + hitCard);
				if (player.isBusted()) {
					System.out.println("Player busted... Oh no!");
					System.out.println("Dealer Wins!");
					return;
				}
				if (player.hasBlackjack()) {
					break whileStatement;
				} else {
					break;
				}
			case STAND:
				break whileStatement;
			}
		}
	}

	public GameMode selectMode() {
		try {
			String response;
			do {
				out.println("Select either console (c) or file (f) input: ");
				response = in.readLine();
			} while (!response.equals("c") && !response.equals("f"));

			if (response.equals("c")) {
				return new ConsoleGameMode(in);
			}

			while (true) {
				out.println("What file do you want to use as input? ");

				Path file = Paths.get(in.readLine());
				if (!Files.exists(file)) {
					out.println("I could not find the file: " + file);
				} else {
					return new FileGameMode(file);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
