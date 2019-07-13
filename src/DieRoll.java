import java.util.Random;
import java.util.Scanner;

public class DieRoll {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to the Grand Circus Casino!");
		int count = 0;
		char userchoice = 'Y';
		do {
			System.out.println("How many sides should each die have?");
			int n = scnr.nextInt();
			System.out.println("Roll the dice! ");
			System.out.println("Roll " + ++count + ":");
			int firstDieRoll = generateRandomDieRoll(n);
			int secondDieRoll = generateRandomDieRoll(n);
			System.out.println(firstDieRoll);
			System.out.println(secondDieRoll);
			specialMessage(firstDieRoll, secondDieRoll);
			System.out.println("Roll again(y/n): ");
			userchoice = scnr.next().charAt(0);
		} while ((userchoice == 'Y') || (userchoice == 'y'));
		System.out.println("Goodbye!");
		scnr.close();
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * Set<Integer> ts = new TreeSet<>(); for (int i = 0; i < 10000000; i++) { int x
	 * = generateRandomDieRoll(6); if ((x <= 0) || (x >= 7)) { throw new
	 * Exception("Generated out of bound value"); } ts.add(x); }
	 * System.out.println(ts); }
	 */
	private static void specialMessage(int firstDieRoll, int secondDieRoll) {

		if (firstDieRoll == 1 && secondDieRoll == 1) {
			System.out.println("Snake Eyes");
		} else if (firstDieRoll == 6 && secondDieRoll == 6) {
			System.out.println("Box cars");
		} else {
			int sumOfDice = firstDieRoll + secondDieRoll;
			if ((sumOfDice == 2) || (sumOfDice == 3) || (sumOfDice == 12)) {
				System.out.println("Craps");
			}
		}
	}

	public static int generateRandomDieRoll(int n) {

		Random rand = new Random();
		return rand.nextInt(n) + 1;
	}
}
