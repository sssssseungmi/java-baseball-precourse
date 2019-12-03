import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String computerInput;
	private static int strike;
	private static int ball;
	private static int nothing;
	private static String command;

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		while (true) {
			randomize();
			startGame();
			inputCommand();

			if (command.equals("1")) {
				continue;
			} else {
				break;
			}
		}
	}

	private static void randomize() {
		computerInput = "";
		Set<Integer> checkNumberSet = new HashSet<>();
		Random generator = new Random();
		for (int i = 0; i < 3; i++) {
			int randomDigit = generator.nextInt(9) + 1;
			if (checkNumberSet.contains(randomDigit)) {
				i--;
			} else {
				checkNumberSet.add(randomDigit);
				computerInput += randomDigit;
			}
		}
		System.out.println(computerInput);
	}

	private static void startGame() {
		while (true) {
			System.out.print("���ڸ� �Է����ּ���: ");
			String userInput = sc.nextLine();
			if (userInput.length() != 3) {
				System.out.println("3�ڸ� ���ڸ� �Է����ּ���!!");
				continue;
			}
			compare(userInput, computerInput);
			printResult();
			if (strike == 3) {
				System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
				break;
			}
		}

	}

	private static void compare(String userInput, String computerInput) {
		strike = 0;
		ball = 0;
		nothing = 0;
		for (int i = 0; i < 3; i++) {
			char digit = userInput.charAt(i);
			if (computerInput.charAt(i) == digit) {
				strike++;
			} else if (computerInput.contains(digit + "")) {
				ball++;
			} else {
				nothing++;
			}
		}
	}

	private static void printResult() {
		if (strike > 0) {
			System.out.print(strike + "��Ʈ����ũ ");
		}
		if (ball > 0) {
			System.out.print(ball + "�� ");
		}
		if (nothing > 0) {
			System.out.print(nothing + "���� ");
		}
		System.out.println();
	}

	private static void inputCommand() {
		System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		while (true) {
			command = sc.nextLine();
			if (command.equals("1")) {
				break;
			} else if (command.equals("2")) {
				break;
			} else {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���!(���� ����: 1, ����: 2)");
			}
		}
	}
}
