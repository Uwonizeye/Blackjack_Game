package common;

public interface GameMode {
	
	enum Move {
		SPLIT,
		HIT,
		STAND
	};

	Card getCard();

	Move getPlayerMove();

}
