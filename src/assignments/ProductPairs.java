package assignments;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProductPairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int nums[] = new int[n];
		String[] arr = sc.nextLine().split(" ");
		
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(arr[i]);
		
		int target = Integer.parseInt(sc.nextLine());
		
		System.out.println(countPairsOfProduct(nums, target));
	}

	private static int countPairsOfProduct(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> pairs = new HashMap<>(); 
		
		int zeros = 0;
		
		for(int i : nums) {
			if(i == 0)
				zeros++;
			set.add(i);
		}
		
		if(target == 0 && set.contains(0))
			return zeros > 1 ? set.size() : set.size() - 1;
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			int num = it.next();
			if(num != 0 && target % num == 0 && set.contains(target/num)) {
				if(!pairs.containsKey(target/num))
					pairs.put(num, target/num);
				else if(pairs.get(target/num) != num)
					pairs.put(num, target/num);
			}
		}
		
//		System.out.println(pairs);
		
		return pairs.size();
	}
}
/**
 * 5
 * 7 -9 -8 4 1
 * 28
 * 
 * {7:4, }
 * 
 */

/**
 * 0 0 0 0 
 * 1
 *
 * 1 1 1 1
 * 1
 *
 * 0 -1 3 0 3
 * 3
 */


/*

Your task is to find number of pairs from the given array which gives product k, where k is an integer.



Example 1:

Input:

5
7 -9 -8 4 1
28



Output:

1

*/
