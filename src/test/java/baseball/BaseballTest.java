package baseball;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

	@DisplayName("올바르지 않은 사용자 입력 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1234", "56", "a12", "012", "abc123"})
	void query_invalid_input(String input) {
		Baseball baseball = Baseball.newGame();
		assertThatThrownBy(() -> baseball.query(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("정답 랜덤 숫자 세팅")
	@Test
	void correct_setting() throws IllegalAccessException, NoSuchFieldException {
		Baseball baseball = Baseball.newGame();
		List<Integer> correct = getCorrect(baseball);

		Set<Integer> set = new HashSet<>();
		assertThat(correct.size()).isEqualTo(3);
		for (Integer number : correct) {
			set.add(number);
			assertThat(number).isBetween(1, 9);
		}
		assertThat(correct.size()).isEqualTo(set.size());
	}

	private List<Integer> getCorrect(Baseball baseball) throws NoSuchFieldException, IllegalAccessException {
		Field field = baseball.getClass().getDeclaredField("correct");
		field.setAccessible(true);
		return (List<Integer>)field.get(baseball);
	}
}