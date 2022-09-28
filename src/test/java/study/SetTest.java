package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("size() Set 크기 확인 테스트")
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
		numbers.add(4);
		assertThat(numbers.size()).isEqualTo(4);
		numbers.add(4);
		assertThat(numbers.size()).isNotEqualTo(5);
		assertThat(numbers.size()).isEqualTo(4);
	}

	@DisplayName("contains() 값 존재 확인 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("contains() 값 존재 확인 테스트, CsvSource 활용")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains_CsvSource(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
