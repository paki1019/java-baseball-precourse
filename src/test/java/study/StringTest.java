package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
	@Test
	void split() {
		String str = "1,2";
		assertThat(str.split(",")).containsExactly("1", "2");
		str = "1";
		assertThat(str.split(",")).containsExactly("1");
	}

	@Test
	void substring() {
		String str = "(1,2)";
		assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
	}

	@Test
	void charAt() {
		String str = "abc";
		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');
	}

	@Test
	@DisplayName("chatAt() 인덱스 음수 테스트")
	void charAt_index_negative() {
		String str = "abc";
		assertThatThrownBy(() -> str.charAt(-1))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: ");
	}

	@Test
	@DisplayName("chatAt() 인덱스 문자열 길이 초과 테스트")
	void charAt_index_out_of_bounds() {
		String str = "abc";
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> str.charAt(str.length()))
			.withMessageMatching("String index out of range: \\d+");
	}
}
