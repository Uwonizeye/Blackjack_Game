package common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
	
	private List<Card> cards = new ArrayList<>();

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public boolean hasHighAce() {
		boolean hasAce = false;
		int totalValue = 0;
		for (Card card: cards) {
			if (card.isAce()) {
				hasAce = true;
			}
			totalValue += card.getCardRank().value();
		}
		
		return (hasAce && totalValue <= 11);
	}

	public int getValue() {
		boolean hasAce = false;
		int totalValue = 0;
		for (Card card: cards) {
			if (card.isAce()) {
				hasAce = true;
			}

			totalValue += card.getCardRank().value();
		}
		
		if (hasAce && totalValue <= 11) {
			totalValue += 10;
		}

		return totalValue;
	}
	
	public boolean hasBlackjack() {
		return cards.size() == 2 && getValue() == 21;
	}

	public boolean isBusted() {
		return getValue() > 21;
	}
	
	public String toString() {
		return cards.stream().map(Card::toString).collect(Collectors.joining(", "));
	}
}
