import java.util.Random;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		while (true) {
			String computerInput = randomize();

			startGame(computerInput);

			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
			String command = command();
			if (command.equals("1")) {
				continue;
			} else {
				break;
			}
		}
	}

	private static String randomize() {
		String number = "";
		boolean[] check = new boolean[10];
		Random generator = new Random();
		for (int i = 0; i < 3; i++) {
			int randomNumber = generator.nextInt(9) + 1;
			if (check[randomNumber]) {
				i--;
			} else {
				check[randomNumber] = true;
				number += randomNumber;
			}
		}
		System.out.println(number);
		return number;
	}

	private static void startGame(String computerInput) {
		while (true) {
			System.out.print("���ڸ� �Է����ּ���: ");
			String userInput = sc.nextLine();

			int strike = compare(userInput, computerInput);
			if (strike == 3) {
				System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
				break;
			}
		}

	}

	private static int compare(String userInput, String computerInput) {
		int strike = 0;
		int ball = 0;
		int nothing = 0;

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
		return strike;
	}

	private static String command() {
		String command = "";
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
		return command;
	}
}
