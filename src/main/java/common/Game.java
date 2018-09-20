package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Game {
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			GameMode mode = Game.selectMode(in, System.out);
			
			Game game = new Game(mode);
			game.play();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private GameMode mode;

	public Game(GameMode mode) {
		this.mode = mode;
	}
	
	public enum Winner {
		PLAYER,
		DEALER
	}

	public Winner play() {
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
			System.out.println("Dealer reveals cards " + dealer.getHand() + " for a value of " + dealer.getValue());
			System.out.println("Dealer got a blackjack! Did you cross a black cat?");
			System.out.println("Dealer Wins!");
			return Winner.DEALER;
		} else if (player.hasBlackjack()) {
			System.out.println("Player Wins!");
			return Winner.PLAYER;
		}
		
		System.out.println("Player's hand is " + player.getHand() + " for a value of " + player.getValue() +".");

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
					return Winner.DEALER;
				}
				System.out.println("Player's hand is " + player.getHand() + " for a value of " + player.getValue() +".");
				if (player.hasBlackjack()) {
					break whileStatement;
				} else {
					break;
				}
			case STAND:
				break whileStatement;
			}
		}
		
		// Dealer Moves
		while (dealer.shouldHit()) {
			Card hitCard = mode.getCard();
			dealer.addCard(hitCard);
			System.out.println("Dealer was dealt " + hitCard);
			
			if (dealer.isBusted()) {
				System.out.println("Dealer reveals cards " + dealer.getHand() + " for a value of " + dealer.getValue());
				System.out.println("Dealer busted! Yikes!");
				System.out.println("Playa Wins!");
				return Winner.PLAYER;
			}
		}

		System.out.println("Dealer reveals cards " + dealer.getHand() + " for a value of " + dealer.getValue());

		if (dealer.getValue() >= player.getValue()) {
			System.out.println("Dealer outsmarted Player!");
			System.out.println("Dealer Wins!");
			return Winner.DEALER;
		} else {
			System.out.println("Player outmaneauvered Dealer!");
			System.out.println("Player Wins!");
			return Winner.PLAYER;
		}
	}

	public static GameMode selectMode(BufferedReader in, PrintStream out) {
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
