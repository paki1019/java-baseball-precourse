package baseball;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
	private static final Pattern inputPattern = Pattern.compile("^[1-9]{3}$");

	private final List<Integer> correct;
	private boolean playing = true;

	private Baseball() {
		this.correct = Collections.unmodifiableList(
			Randoms.pickUniqueNumbersInRange(1, 9, 3)
		);
	}

	public static Baseball newGame() {
		return new Baseball();
	}

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
