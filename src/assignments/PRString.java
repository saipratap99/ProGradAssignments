package assignments;

import java.util.Scanner;

public class PRString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();

		System.out.println(isPRString(inputString) ? "perfect" : "imperfect");
		System.out.println(isPRStringUsingPattern(inputString) ? "perfect" : "imperfect");
		System.out.println(isPRStringUsingTwoPointer(inputString) ? "perfect" : "imperfect");

	}

	// PRPR

	public static boolean isPRStringUsingTwoPointer(String inputString) {
		if (inputString.length() == 0)
			return true;

		if (inputString.equals("P") || inputString.equals("R") || inputString.equals("PR") || inputString.equals("RP"))
			return true;

		int len = inputString.length();
		int first = 0, last = len - 1;
		while (first <= last) {

			if (first == last)
				return !(inputString.charAt(first) != 'P' && inputString.charAt(first) != 'R');

			char firstChar = inputString.charAt(first), lastChar = inputString.charAt(last);

			if ((firstChar != 'P' && firstChar != 'R') || (lastChar != 'P' && lastChar != 'R'))
				return false;

			System.out.println(firstChar + " " + lastChar);

			if (len % 2 == 0)
				if (!(firstChar == 'P' && lastChar == 'R') && !(firstChar == 'R' && lastChar == 'P'))
					return false;
				else if (firstChar != lastChar)
					return false;
			first++;
			last--;
		}

		return true;
	}

	public static boolean isPRString(String inputString) {
		if (inputString.length() == 0)
			return true;

		if (inputString.equals("P") || inputString.equals("R") || inputString.equals("PR") || inputString.equals("RP"))
			return true;

		char curr = inputString.charAt(0) == 'P' ? 'P' : 'R';
		char next = curr == 'P' ? 'R' : 'P';

		for (int i = 0; i < inputString.length() - 1; i++) {
			if (inputString.charAt(i) == curr && inputString.charAt(i + 1) == next) {
				char temp = curr;
				curr = next;
				next = temp;
			} else
				return false;
		}
		return true;
	}

	public static boolean isPRStringUsingPattern(String inputString) {
		if (inputString.length() == 0)
			return true;

		if (inputString.equals("P") || inputString.equals("R") || inputString.equals("PR") || inputString.equals("RP"))
			return true;

		int len = inputString.length();
		if (len % 2 == 0)
			return inputString.matches("[PR]*");
		else
			return inputString.substring(0, len - 2).matches("[PR]*")
					&& inputString.charAt(0) == inputString.charAt(len - 1);

	}
}