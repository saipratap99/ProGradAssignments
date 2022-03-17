package assignments;

import java.util.*;
public class PermutationsCount
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    
        String str = sc.nextLine().toLowerCase();
    
        System.out.println(str + ": " + permuationsCount(str));
	
    }


    public static long permuationsCount(String str){
        HashMap<Character, Integer> freq = new HashMap();
        
        for(char ch : str.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        
        long count = calCulateFactorial(str.length());

        for(Map.Entry<Character, Integer> ch: freq.entrySet())
            count /= calCulateFactorial(ch.getValue());
    
        return count;
    }

    public static long calCulateFactorial(int n){
    
        if(n == 0)
            return 1;
        // return n*calCulateFactorial(n-1);

        long fact = n;
        for(int i = n - 1; i >= 1; i--)
            fact *= i;

        return fact;
        
    }
}

/*

abc = 3*2*1
aab {aab, aba, baa}

*/