package common;

import java.nio.file.Path;

public class FileGameMode implements GameMode {

	private Path file;

	public FileGameMode(Path file) {
		this.file = file;
	}

	@Override
	public Card getCard() {
		return null;
	}

}
