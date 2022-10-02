package study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionsTest {

	@DisplayName("Collections.unmodifiableList 불변 테스트")
	@Test
	void unmodifiableList() {
		List<Integer> modifiable = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> unmodifiable = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(4, 5, 6)));

		modifiable.add(4);
		assertThat(modifiable).containsExactly(1, 2, 3, 4);
		assertThatThrownBy(() -> unmodifiable.add(7)).isInstanceOf(UnsupportedOperationException.class);
	}
}
