package baseball;

import java.util.ArrayList;
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
		List<Integer> numberInput = convertInput(input);
		Result result = Result.generate(correct, numberInput);

		if (result.isCorrect()) {
			this.playing = false;
		}
		return result.getResultMessage();
	}

	private List<Integer> convertInput(String input) {
		List<Integer> list = new ArrayList<>();
		for (String s : input.split("")) {
			list.add(Integer.parseInt(s));
		}
		return list;
	}

	private void validateInput(String input) {
		if (!inputPattern.matcher(input).matches()) {
			throw new IllegalArgumentException();
		}
	}
}
