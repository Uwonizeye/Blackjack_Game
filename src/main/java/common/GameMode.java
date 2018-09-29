package common;

public interface GameMode {
	
	enum Move {
		HIT,
		STAND
	};

	Card getCard();

	Move getPlayerMove();

}

