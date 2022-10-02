package baseball;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {
	private final List<Integer> correct;
	private final List<Integer> input;

	private int strikeCount;
	private int ballCount;

	public Result(List<Integer> correct, List<Integer> input) {
		this.correct = Collections.unmodifiableList(correct);
		this.input = Collections.unmodifiableList(input);
		setResultCount();
	}

	private void setResultCount() {
		for (int i = 0; i< input.size(); i++) {
			addResultCount(i, input.get(i));
		}
	}

	private void addResultCount(int i, Integer number) {
		if (Objects.equals(number, correct.get(i))) {
			strikeCount++;
			return;
		}

		if (correct.contains(number)) {
			ballCount++;
			return;
		}
		return;
	}

	public static Result generate(List<Integer> correct, List<Integer> input) {
		return new Result(correct, input);
	}

	public boolean isCorrect() {
		return strikeCount == 3;
	}

	public String getResultMessage() {
		return null;
	}
}
