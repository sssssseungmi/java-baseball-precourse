import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * ���ھ߱�����
 * 
 * @author sssssseungmi
 * @className BaseballGame
 * @date 2019.12.03
 * @version 1.0
 */
public class BaseballGame {
	/** 3�ڸ� ���� üũ�ϱ� ���� ��� */
	private static final int THREE = 3;

	/** Input�� �ޱ� ���� Scanner ���� */
	private static Scanner sc = new Scanner(System.in);
	/** �������� ������ ��ǻ���� �� �ڸ� ���ڸ� ���� ���� */
	private static String computerInput;
	/** Strike�� ������ ������ ���� */
	private static int strike;
	/** Ball�� ������ ������ ���� */
	private static int ball;
	/** Nothing�� ������ ������ ���� */
	private static int nothing;
	/** ���� ���۰� ���Ḧ �Ǵ��� Command ���� */
	private static String command;

	/**
	 * ���α׷��� ���ʷ� �����ϴ� main�Լ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
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

	/**
	 * ��ǻ�Ͱ� �� �ڸ� ���ڸ� ����� �Լ��Դϴ�. HashSet���� �ߺ��Ǵ� ���ڸ� üũ�մϴ�.
	 */
	private static void randomize() {
		computerInput = "";
		Set<Integer> checkNumberSet = new HashSet<>();
		Random generator = new Random();
		for (int i = 0; i < THREE; i++) {
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

	/**
	 * ������ computerInput�� �������� ����ڿ� ������ �����ϴ� �Լ��Դϴ�. user�� 3���� ���ڸ� ��� ������ ����˴ϴ�.
	 */
	private static void startGame() {
		while (true) {
			System.out.print("���ڸ� �Է����ּ���: ");
			String userInput = sc.nextLine();
			if (userInput.length() != THREE) {
				System.out.println("3�ڸ� ���ڸ� �Է����ּ���!!");
				continue;
			}
			compare(userInput, computerInput);
			printResult();
			if (strike == THREE) {
				System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
				break;
			}
		}

	}

	/**
	 * user�� �Է��� input�� ��ǻ�Ͱ� ������ ���ڸ� ���� ���ϴ� �Լ��Դϴ�.
	 * 
	 * @param userInput
	 * @param computerInput
	 */
	private static void compare(String userInput, String computerInput) {
		strike = 0;
		ball = 0;
		nothing = 0;
		for (int i = 0; i < THREE; i++) {
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

	/**
	 * ���� ����� ����ϴ� �Լ��Դϴ�.
	 */
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

	/**
	 * ������ ���� �������� �������� �Ǵ��ϴ� �Լ��Դϴ�.
	 * 1�� �Է��ϸ� ���� ����, 2�� �Է��ϸ� ����,�� �ܸ̿� �Է��ϸ� �Է��� �ٽ� �޽��ϴ�.
	 */
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
