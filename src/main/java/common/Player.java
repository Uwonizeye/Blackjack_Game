package common;

public class Player {

	private Hand hand = new Hand();

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public boolean hasBlackjack() {
		return hand.hasBlackjack();		
	}

	public boolean isBusted() {
		return hand.isBusted();
	}
}

