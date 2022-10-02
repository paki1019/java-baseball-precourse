package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

	@DisplayName("올바르지 않은 사용자 입력 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1234", "56", "a12", "012", "abc123"})
	void query_invalid_input(String input) {
		Baseball baseball = new Baseball();
		assertThatThrownBy(() -> baseball.query(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
}