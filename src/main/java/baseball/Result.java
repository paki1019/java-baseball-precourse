package baseball;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {
	private final List<Integer> correct;
	private final List<Integer> input;

	private int strikeCount;
	private int ballCount;

	private Result(List<Integer> correct, List<Integer> input) {
		this.correct = Collections.unmodifiableList(correct);
		this.input = Collections.unmodifiableList(input);
		checkResult();
	}

	public static Result generate(List<Integer> correct, List<Integer> input) {
		return new Result(correct, input);
	}

	private void checkResult() {
		for (int i = 0; i < input.size(); i++) {
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
		}
	}

	public boolean isCorrect() {
		return strikeCount == correct.size();
	}

	public String getResultMessage() {
		if (this.ballCount != 0 && this.strikeCount != 0) {
			return String.format("%d볼 %d스트라이크", this.ballCount, this.strikeCount);
		}
		if (this.ballCount != 0) {
			return String.format("%d볼", this.ballCount);
		}
		if (this.strikeCount != 0) {
			return String.format("%d스트라이크", this.strikeCount);
		}
		return "낫싱";
	}
}
