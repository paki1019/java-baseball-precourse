package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static boolean replay;
	public static boolean checkingReplayInput;

	public static void main(String[] args) {
		do {
			playBaseballGame();
			checkReplay();
		} while (replay);
	}

	private static void playBaseballGame() {
		Baseball baseball = new Baseball();
		while (baseball.isPlaying()) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();
			String output = baseball.query(input);
			System.out.println(output);
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private static void checkReplay() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		checkingReplayInput = true;
		do {
			inputReplay();
		} while (checkingReplayInput);
	}

	private static void inputReplay() {
		String inputReplay = Console.readLine();
		if (inputReplay.equals("1")) {
			checkingReplayInput = false;
			replay = true;
		}
		if (inputReplay.equals("2")) {
			checkingReplayInput = false;
			replay = false;
		}
	}
}
