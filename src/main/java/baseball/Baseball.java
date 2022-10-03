package baseball;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Baseball {
	private static final Pattern inputPattern = Pattern.compile("^[1-9]{3}$");

	private final List<Integer> correct;
	private boolean playing = true;

	private Baseball() {
		this.correct = Collections.unmodifiableList(
			BaseballUtils.generateUniqueRandomNumbers(1, 9, 3)
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
		List<Integer> numberInput = BaseballUtils.convertIntegerList(input);
		Result result = Result.generate(correct, numberInput);

		if (result.isCorrect()) {
			this.playing = false;
		}
		return result.getResultMessage();
	}

	private void validateInput(String input) {
		if (!inputPattern.matcher(input).matches()) {
			throw new IllegalArgumentException();
		}
	}
}
