package baseball;

public class Baseball {
	private boolean playing = true;

	public boolean isPlaying() {
		return playing;
	}

	public String query(String input) {
		if (collect(input)) {
			this.playing = false;
		}
		return "string";
	}

	private boolean collect(String input) {
		return input.equals("123");
	}
}
