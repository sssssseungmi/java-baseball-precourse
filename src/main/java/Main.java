import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
	}

	private static void init() {

		while (true) {
			String computerInput = randomize();

			startGame(computerInput);

			System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");

			int command = sc.nextInt();
			if (command == 1) {
				continue;
			} else if (command == 2) {
				break;
			} else {

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
			
			
		}

	}

	

}
