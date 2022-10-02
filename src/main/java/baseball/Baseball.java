package baseball;

import java.util.regex.Pattern;

public class Baseball {
	private static final Pattern inputPattern;

	static {
		inputPattern = Pattern.compile("^[1-9]{3}$");
	}

	private boolean playing = true;

	public boolean isPlaying() {
		return playing;
	}

	public String query(String input) {
		validateInput(input);
		if (collect(input)) {
			this.playing = false;
		}
		return "string";
	}

	private void validateInput(String input) {
		if (!inputPattern.matcher(input).matches()) {
			throw new IllegalArgumentException();
		}
	}

	private boolean collect(String input) {
		return input.equals("123");
	}
}
