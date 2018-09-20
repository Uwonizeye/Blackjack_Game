package common;

public class Dealer {
	
	private Hand hand = new Hand();

	public boolean shouldHit() {
		return hand.getValue() <= 16 || hasSoftSeventeen();
	}
	
	public boolean hasSoftSeventeen() {
		return hand.hasHighAce() && hand.getValue() == 17;
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public boolean hasBlackjack() {
		return hand.hasBlackjack();
	}
}
