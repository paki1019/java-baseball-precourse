package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballUtils {
	public static List<Integer> generateUniqueRandomNumbers(
		final int startInclusive,
		final int endInclusive,
		final int count
	) {
		validateCount(startInclusive, endInclusive, count);
		List<Integer> list = new ArrayList<>();
		while (list.size() != count) {
			addRandomNumber(list, startInclusive, endInclusive);
		}
		return list;
	}

	private static void validateCount(final int startInclusive, final int endInclusive, final int count) {
		if (count < 0) {
			throw new IllegalArgumentException();
		}
		if (endInclusive - startInclusive + 1 < count) {
			throw new IllegalArgumentException();
		}
	}

	private static void addRandomNumber(
		List<Integer> list,
		final int startInclusive,
		final int endInclusive
	) {
		int i = Randoms.pickNumberInRange(startInclusive, endInclusive);
		if (!list.contains(i)) {
			list.add(i);
		}
	}

	public static List<Integer> convertIntegerList(String str) {
		validateStr(str);
		List<Integer> list = new ArrayList<>();
		for (String s : str.split("")) {
			list.add(Integer.parseInt(s));
		}
		return list;
	}

	private static final Pattern integerStrPattern = Pattern.compile("^[0-9]*$");

	private static void validateStr(String str) {
		if (!integerStrPattern.matcher(str).matches()) {
			throw new IllegalArgumentException();
		}
	}
}
