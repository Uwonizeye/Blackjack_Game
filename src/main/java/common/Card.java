package common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Card {
	
	public static final Set<Card> allCards;

	static {
		Set<Card> cards = new HashSet<Card>();
		for (Suit suit: Suit.values()) {
			for (Rank rank: Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		
		allCards = Collections.unmodifiableSet(cards);
	}
	
	// Note: In this game ACE can also be worth 11 if the other card is less than 11, this will be dealt with separately
	
	public enum Rank{
		ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
		EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");
		
		public final String label;
		Rank(String label){
			this.label = label;
		}
		
		public int value() {
			return Math.min(ordinal() + 1, 10);
		}
	};
	
	public enum Suit{
		S, H, D, C;
	};
	
	private final Rank rank;
	private final Suit suit;
	
	// Card constructor
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	// Initializes a card
	public static Card valueOf (int num) {
		int rankNumber = num%13;
		int suitNumber = num%4;
		Rank[] ranks = Rank.values();
		Suit[]suits = Suit.values();
		Card card = new Card(ranks[rankNumber], suits[suitNumber]);
				
		return card;
	}
	
//  Equals& hashcode overriden 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	//Get rank of a card
	
	public Rank getCardRank(){
		return rank;
	}
	
	//Get suit of a card
	public Suit getCardSuit(){
		return suit;
	}
		
	// Check if card is ACE
	public boolean isAce(){
		return rank.equals(Rank.ACE);
	}
	
	// Check if card is K
	public boolean isKing(){
		return rank.equals(Rank.KING);
	}
	
	// Check if card is Q
	public boolean isQueen(){
		return rank.equals(Rank.QUEEN);
	}
	
	// Check if card is J
	public boolean isJack(){
		return rank.equals(Rank.JACK);
	}
	
	// Case where ace is 11 i.e. high
	//??
	
	
	// toString method to represent individual cards
	//For regular cards:H4 or C8
	//For aces:HA or SA
	//For KQJ: SK, JH
	@Override public String toString() {
		return suit.name() + rank.label;
	}	
}