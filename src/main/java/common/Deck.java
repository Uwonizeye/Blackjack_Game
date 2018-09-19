package common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck {



	private List<Card> cards;
	public Deck(Random random) {
		cards = new ArrayList<Card>(Card.values().length);
		cards.addAll(Arrays.asList(Card.values()));
		Collections.shuffle(cards, random);
	}
	
	// Checks the current deck size
	public int cardsLeft() {
		return cards.size();
	}

	//  Equals& hashcode overriden to be able to compare 2 decks
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return cards.stream().map(Card::toString).collect(Collectors.joining(", ", "[", "]"));
	}
}
