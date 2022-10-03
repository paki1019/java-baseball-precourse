package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballUtilsTest {

	static Stream<Arguments> convertIntegerListData() {
		return Stream.of(
			Arguments.of("123", Arrays.asList(1, 2, 3)),
			Arguments.of("456", Arrays.asList(4, 5, 6)),
			Arguments.of("789", Arrays.asList(7, 8, 9)),
			Arguments.of("1152", Arrays.asList(1, 1, 5, 2))
		);
	}

	@DisplayName("랜덤 숫자 리스트 생성 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1, 9, 3", "10, 11, 2"}, delimiter = ',')
	void generateUniqueRandomNumbers(
		final int startInclusive,
		final int endInclusive,
		final int count
	) {
		List<Integer> randomNumbers = BaseballUtils.generateUniqueRandomNumbers(startInclusive, endInclusive, count);
		Set<Integer> set = new HashSet<>();
		assertThat(randomNumbers.size()).isEqualTo(count);
		for (Integer number : randomNumbers) {
			set.add(number);
			assertThat(number).isBetween(startInclusive, endInclusive);
		}
		assertThat(set.size()).isEqualTo(count);
	}

	@DisplayName("랜덤 숫자 리스트 생성 실패 테스트")
	@ParameterizedTest
	@CsvSource(value = {"10, 7, 3", "10, 11, 3", "1, 1, -1"}, delimiter = ',')
	void generateUniqueRandomNumbers_IllegalArgumentException(
		final int startInclusive,
		final int endInclusive,
		final int count
	) {
		assertThatThrownBy(() -> BaseballUtils.generateUniqueRandomNumbers(startInclusive, endInclusive, count))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자열 숫자 리스트 변환 테스트")
	@ParameterizedTest
	@MethodSource("convertIntegerListData")
	void convertIntegerList(String str, List<Integer> expected) {
		assertThat(BaseballUtils.convertIntegerList(str)).isEqualTo(expected);
	}


	@DisplayName("문자열 숫자 리스트 변환 실패 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"a12", "01a2", "abc123", "-1"})
	void convertIntegerList_IllegalArgumentException(String str) {
		assertThatThrownBy(() -> BaseballUtils.convertIntegerList(str))
			.isInstanceOf(IllegalArgumentException.class);
	}
}