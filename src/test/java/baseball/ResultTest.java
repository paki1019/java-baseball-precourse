package baseball;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

	static Stream<Arguments> isCorrectData() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), true),
			Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4), false),
			Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(0, 0, 0), false)
		);
	}

	static Stream<Arguments> getStrikeData() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3),
			Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4), 2),
			Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(0, 0, 0), 0)
		);
	}

	static Stream<Arguments> getBallData() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 0),
			Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 1, 4), 2),
			Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(5, 0, 0), 1),
			Arguments.of(Arrays.asList(4, 9, 6), Arrays.asList(9, 9, 9), 2)
		);
	}

	@DisplayName("결과 여부 테스트")
	@ParameterizedTest
	@MethodSource("isCorrectData")
	void isCorrect(List<Integer> correct, List<Integer> input, boolean expected) {
		Result result = Result.generate(correct, input);
		assertThat(result.isCorrect()).isEqualTo(expected);
	}

	@DisplayName("스트라이크 갯수 테스트")
	@ParameterizedTest
	@MethodSource("getStrikeData")
	void getStrikeData(List<Integer> correct, List<Integer> input, int expected) throws
		NoSuchFieldException, IllegalAccessException {
		Result result = Result.generate(correct, input);
		assertThat(getFieldValue(result, "strikeCount")).isEqualTo(expected);
	}

	@DisplayName("볼 갯수 테스트")
	@ParameterizedTest
	@MethodSource("getBallData")
	void getBallData(List<Integer> correct, List<Integer> input, int expected) throws
		NoSuchFieldException, IllegalAccessException {
		Result result = Result.generate(correct, input);
		assertThat(getFieldValue(result, "ballCount")).isEqualTo(expected);
	}

	private int getFieldValue(Result object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
		Field field = object.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return (int)field.get(object);
	}
}