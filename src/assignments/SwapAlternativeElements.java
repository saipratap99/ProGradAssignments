package assignments;

import java.util.*;

public class SwapAlternativeElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfElements = Integer.parseInt(sc.nextLine());
		List<Integer> inputList = new ArrayList<>();

		String[] splitedLine = sc.nextLine().split(" ");

		for (int i = 0; i < numberOfElements; i++)
			inputList.add(Integer.parseInt(splitedLine[i]));

		swapAlternateElements(inputList);

		System.out.println(inputList);

	}

	public static void swapAlternateElements(List<Integer> inputList) {
		for (int i = 1; i < inputList.size(); i += 2)
			swap(inputList, i - 1, i);
	}

	public static void swap(List<Integer> inputList, int prev, int curr) {
		int prevElement = inputList.get(prev);
		inputList.set(prev, inputList.get(curr));
		inputList.set(curr, prevElement);
	}
}

/*
 * 
 * 0 1 2 3 4 5 6 7 - indexes 1 2 3 4 5 6 7 8 - list
 * 
 * 1st, f = 0, l = 7
 * 
 * 2 1 3 4 5 6 8 7
 * 
 * ---------------
 * 
 * 2nd, f = 2, l = 5
 * 
 * 2 1 4 3 6 5 8 7 ---------------- f = 4, l = 3
 * 
 * 8/4 = 2
 * 
 */