package common;

public enum Card {
	SPADE_ACE("SA", 1, Category.Spade),
	HEART_ACE("HA", 1, Category.Heart),
	DIAMOND_ACE("DA", 1, Category.Diamond),
	CLUB_ACE("CA", 1, Category.Club),
	// .. others
	;
	
	public enum Category {
		Spade,
		Heart,
		Diamond,
		Club
	};
	
	public final String label;
	public final int rank;
	public final Category category;
	
	private Card(String label, int rank, Category category) {
		this.label = label;
		this.rank = rank;
		this.category = category;
	}
}
