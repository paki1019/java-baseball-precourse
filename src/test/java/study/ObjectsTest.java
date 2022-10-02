package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ObjectsTest {

	@DisplayName("Objects.equals() null 일치 테스트")
	@Test
	void equals() {
		String null1 = null;
		String null2 = null;
		assertThat(Objects.equals(null1, null2)).isTrue();
	}
}
