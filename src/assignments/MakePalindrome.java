package assignments;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class MakePalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		System.out.println(word 
							+ ": " + (isPalindrome(word.toLowerCase()) ? word :
										makePalindromeUsingTwoPointer(word.toLowerCase())));
	}

	public static boolean isPalindrome(String word) {
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString().equals(word);
	}

	public static String makePalindromeUsingTwoPointer(String word) {
		StringBuilder sb = new StringBuilder(word);

		int len = word.length();
		int first = 0, last = len - 1;
		while (first < last) {
			if (sb.charAt(first) != sb.charAt(last))
				sb.insert(last + 1, new char[] { sb.charAt(first++) });
			else {
				first++;
				last--;
			}

		}
		return sb.toString();
	}

}